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
              action="http://localhost:9399/tbk/aliyunOss/uploadImage"
              name="image"
              :drag="true"
              :show-file-list="false"
              :on-success="handleAvatarSuccess"
              :before-upload="beforeAvatarUpload">
              <img v-if="form.image" :src="form.image" class="avatar">
              <i v-else class="el-icon-plus avatar-uploader-icon"></i>
            </el-upload>
            <el-input v-model="form.image" class="common-width" placeholder="点击上传图片或者手动输入图片链接"></el-input>
          </el-form-item>

          <el-form-item label="系统消息标题" prop="title">
            <el-input v-model="form.title" class="common-width" ></el-input>
          </el-form-item>

          <!--<el-form-item label="更新公告(日志)" prop="notice">-->
            <!--<el-input-->
              <!--v-model="form.notice"-->
              <!--class="common-width"-->
              <!--type="textarea"-->
              <!--:rows="15"-->
              <!--placeholder="请输入更新公告"-->
            <!--&gt;-->
            <!--</el-input>-->
          <!--</el-form-item>-->

          <el-form-item label="作者名称" prop="author">
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
  export default {
    name: 'Form',
    mounted() {

      if (this.$route.params.id != null) {
        this.$axios.get("softVersions/getSingleBySoftId",{
          params: {
            softId: this.$route.params.id,
          }
        }).then((rsp) => {
          this.form =rsp.data;
        });

        this.formButtonName = '立即保存';
      }

    },
    data() {
      return {
        open: {
          url: 'SystemMessageList',
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
      }
    },
    methods: {
      handleAvatarSuccess(res, file) {
        this.form.image = file.response.data;
      },
      beforeAvatarUpload(file) {
        const isJPG = true;
        const isLt2M = file.size / 1024 / 1024 < 3;

        // if (!isJPG) {
        //   this.$message.error('上传头像图片只能是 JPG 格式!');
        // }
        if (!isLt2M) {
          this.$message.error('上传图片大小不能超过 3MB!');
        }
        return isJPG && isLt2M;
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
            if (this.$route.params.versionsNum != null) {
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

        let url = "softVersions/create";
        data.softId = this.$route.params.id;
        if (isUpdate == true) {
          data.id = this.id;
          url = "softVersions/update";
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
