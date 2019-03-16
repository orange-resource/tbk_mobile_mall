<template>

  <div>

    <orange-operation-card>

      <div slot="operation" style="display: inline">
        <span @click="openExpress" style="color: #409EFF;cursor: pointer;margin-left: 20px"> 上一页</span>
      </div>

      <div slot="form">
        <el-form :model="form" :rules="forms" :status-icon="true"
                 ref="form" label-width="100px" class="demo-ruleForm">

          <el-form-item label="主图" prop="sort">
            <el-upload
              class="avatar-uploader"
              :drag="true"
              action="/tbk/aliyunOss/uploadImage"
              name="image"
              :show-file-list="false"
              :on-success="handleAvatarSuccess"
              :before-upload="beforeAvatarUpload">
              <img v-if="form.image" :src="form.image" class="avatar">
              <i v-else class="el-icon-plus avatar-uploader-icon"></i>
            </el-upload>
            <el-input v-model="form.image" class="common-width" placeholder="点击上传图片或者手动输入图片链接"></el-input>
          </el-form-item>

          <el-form-item label="排序(开放接口从小到大排序)" prop="sort">
            <el-input v-model="form.sort" class="common-width"></el-input>
          </el-form-item>

          <el-form-item label="点击跳转地址" prop="clickUrl">
            <el-input v-model="form.clickUrl" class="common-width"></el-input>
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
        this.$axios.get("carousel/single",{
          params: {
            carouselId: this.$route.params.id,
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
          url: 'CarouselList',
        },
        formButtonName: '立即创建',

        //表单配置
        form: {
          image: '',
          clickUrl: '',
          sort: '',
        },
        forms: {
          image: [
            {required: true, message: '请上传主图或者填写主图链接', trigger: 'blur'},
          ],
          clickUrl: [
            {required: true, message: '请填写点击跳转链接', trigger: 'blur'},
          ],
          sort: [
            {required: true, message: '请填写排序', trigger: 'blur'},
          ],
        },
        uploadImageLoading: '',
      }
    },
    methods: {
      handleAvatarSuccess(res, file) {
        this.uploadImageLoading.close();
        this.form.image = file.response.data;
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

        let url = "carousel/create";
        if (isUpdate == true) {
          data.id = this.$route.params.id;
          url = "carousel/alter";
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
