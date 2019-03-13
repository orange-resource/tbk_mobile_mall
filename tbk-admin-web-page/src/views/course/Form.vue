<template>

  <div>

    <orange-operation-card>

      <div slot="operation" style="display: inline">
        <span @click="openExpress" style="color: #409EFF;cursor: pointer;margin-left: 20px"> 上一页</span>
      </div>

      <div slot="form">
        <el-form :model="form" :rules="forms" :status-icon="true"
                 ref="form" label-width="100px" class="demo-ruleForm">

          <el-form-item label="主图" prop="image">
            <el-upload
              class="avatar-uploader"
              :drag="true"
              action="..."
              :show-file-list="false"
              :on-success="handleAvatarSuccess"
              :http-request="httpRequest"
              :before-upload="beforeAvatarUpload">
              <img v-if="form.image" :src="form.image" class="avatar">
              <i v-else class="el-icon-plus avatar-uploader-icon"></i>
            </el-upload>
            <el-input v-model="form.image" class="common-width" placeholder="点击上传图片或者手动输入图片链接"></el-input>
          </el-form-item>

          <el-form-item label="教程标题" prop="title">
            <el-input v-model="form.title" class="common-width" ></el-input>
          </el-form-item>

          <el-form-item label="教程内容" prop="content">
            <quill-editor
              v-model="form.content"
              ref="myQuillEditor"
              :options="editorOption"
              style="height: 500px"
              @blur="onEditorBlur($event)" @focus="onEditorFocus($event)"
              @change="onEditorChange($event)">
            </quill-editor>
          </el-form-item>

          <el-form-item label="作者名称" prop="author" style="padding-top: 50px">
            <el-input v-model="form.author" class="common-width"></el-input>
          </el-form-item>

          <el-form-item>
            <el-button type="primary" @click="submitForm('form')">{{ formButtonName }}</el-button>
            <el-button @click="resetForm('form')">重置</el-button>
          </el-form-item>

        </el-form>
      </div>

    </orange-operation-card>

  </div>

</template>

<script>

  import VueQuillEditor, { Quill } from 'vue-quill-editor'
  import { ImageDrop } from 'quill-image-drop-module'
  import ImageResize from 'quill-image-resize-module'
  Quill.register('modules/imageDrop', ImageDrop)
  Quill.register('modules/imageResize', ImageResize)

  export default {
    name: 'Form',
    mounted() {

      if (this.$route.params.id != null) {
        this.$axios.get("course/single",{
          params: {
            courseId: this.$route.params.id,
          }
        }).then((rsp) => {
          this.form = rsp.data;
        });

        this.formButtonName = '立即保存';
      }

    },
    data() {
      return {
        open: {
          url: 'CourseList',
        },
        formButtonName: '立即创建',

        //表单配置
        form: {
          image: '',
          title: '',
          content: '',
          author: '',
        },
        forms: {
          image: [
            {required: true, message: '请上传主图', trigger: 'blur'},
          ],
          title: [
            {required: true, message: '请输入系统消息标题', trigger: 'blur'},
          ],
          content: [
            {required: true, message: '请输入系统消息内容', trigger: 'blur'},
          ],
          author: [
            {required: true, message: '请输入作者名称', trigger: 'blur'},
          ],
        },
        uploadImageLoading: '',
        editorOption:{
          placeholder: "输入详情内容...",
          modules: {
            imageDrop: true,
            imageResize: {
              displayStyles: {
                backgroundColor: 'black',
                border: 'none',
                color: 'white'
              },
            },
            toolbar: [
              ['bold', 'italic', 'underline', 'strike'],
              ['blockquote', 'code-block'],
              [{ 'header': 1 }, { 'header': 2 }],
              [{ 'list': 'ordered' }, { 'list': 'bullet' }],
              [{ 'script': 'sub' }, { 'script': 'super' }],
              [{ 'indent': '-1' }, { 'indent': '+1' }],
              [{ 'direction': 'rtl' }],
              [{ 'size': ['small', false, 'large', 'huge'] }],
              [{ 'header': [1, 2, 3, 4, 5, 6, false] }],
              [{ 'font': [] }],
              [{ 'color': [] }, { 'background': [] }],
              [{ 'align': [] }],
              ['clean'],
              ['link', 'image', 'video']
            ],
          }
        },
      }
    },
    methods: {
      handleAvatarSuccess(res, file) {
        this.uploadImageLoading.close();
        this.form.image = file.response.imagebase64;
      },
      beforeAvatarUpload(file) {
        const isJPG = true;
        const isLt2M = file.size / 1024 / 1024 < 3;

        if (!isLt2M) {
          this.$message.error('上传图片大小不能超过 3MB!');
        } else {
          this.uploadImageLoading = this.$loading({
            lock: true,
            text: 'Loading',
            spinner: 'el-icon-loading',
            background: 'rgba(0, 0, 0, 0.7)'
          });
        }

        return isJPG && isLt2M;
      },
      httpRequest(options) {

        let file = options.file;
        let reader = new FileReader();
        reader.readAsDataURL(file);
        reader.onload = function (e) {
          options.onSuccess({imagebase64: e.currentTarget.result}, options.file);
        }
      },
      openExpress() { //上一页
        this.$router.push({
          name: this.open.url,
        })
      },
      //表单操作
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            if (this.$route.params.id != null) {
              this.submit(true);
            } else {
              this.submit(false);
            }
          } else {
            this.$message.error('提交错误');
            return false;
          }
        });
      },
      submit(isUpdate) {

        let data = this.form;

        let url = "course/create";
        if (isUpdate == true) {
          data.id = this.$route.params.id;
          url = "course/alter";
        }

        this.$axios({
          method: 'post',
          url: url,
          data:this.$qs.stringify(data),
        }).then((rsp) => {
          this.$message(rsp.msg);
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      },
      onEditorBlur(){//失去焦点事件
      },
      onEditorFocus(){//获得焦点事件
      },
      onEditorChange(){//内容改变事件
      },
    }
  }
</script>

<style scoped>
  .avatar-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
  }
  .avatar-uploader .el-upload:hover {
    border-color: #409EFF;
  }
  .avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 178px;
    height: 178px;
    line-height: 178px;
    text-align: center;
  }
  .avatar {
    width: 100%;
    height: 100%;
    display: block;
  }
</style>
