<template>

  <div>

    <orange-operation-card>

      <div slot="form">
        <el-form :model="form" :rules="forms" :status-icon="true"
                 ref="form" label-width="100px" class="demo-ruleForm">

          <el-form-item label="前缀域名" prop="domainName">
            <el-input v-model="form.domainName" class="common-width"></el-input>
          </el-form-item>
          <el-form-item label="图片后缀样式" prop="style">
            <el-input v-model="form.style" class="common-width"></el-input>
          </el-form-item>
          <el-form-item label="endpoint" prop="endpoint">
            <el-input v-model="form.endpoint" class="common-width"></el-input>
          </el-form-item>
          <el-form-item label="keyId" prop="keyId">
            <el-input v-model="form.keyId" class="common-width"></el-input>
          </el-form-item>
          <el-form-item label="keySecret" prop="keySecret">
            <el-input v-model="form.keySecret" class="common-width"></el-input>
          </el-form-item>
          <el-form-item label="bucketName" prop="bucketName">
            <el-input v-model="form.bucketName" class="common-width"></el-input>
          </el-form-item>
          <el-form-item label="目录路径" prop="catalogue">
            <el-input v-model="form.catalogue" class="common-width"></el-input>
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
    mounted() {

      this.$axios.get("aliyunOss/single").then((rsp) => {
        if (rsp.code == 9) {
          this.form = rsp.data;
        }
      }).catch((e) => {
        this.$notify.error({
          title: '系统错误',
          message: '发生了未知错误:\n' + e
        });
      });

    },
    methods: {
      //表单操作
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.submit(true);
          } else {
            this.$message.error('提交错误');
            return false;
          }
        });
      },
      submit() {

        let data = this.form;

        let url = "aliyunOss/create";

        this.$axios({
          method: 'post',
          url: url,
          data:this.$qs.stringify(data),
        }).then((rsp) => {
          this.$message(rsp.msg);
        }).catch((e) => {
          this.$notify.error({
            title: '系统错误',
            message: '发生了未知错误:\n' + e
          });
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      },
    },
    data() {
      return {
        //收起放下
        searchWorkspace: true,

        formButtonName: '立即保存',

        //表单配置
        form: {
          domainName: '',
          style: '',
          endpoint: '',
          keyId: '',
          keySecret: '',
          bucketName: '',
          catalogue: '',
        },
        forms: {
          domainName: [
            {required: true, message: '请填写前缀域名', trigger: 'blur'},
          ],
          endpoint: [
            {required: true, message: '请填写endpoint', trigger: 'blur'},
          ],
          keyId: [
            {required: true, message: '请填写keyId', trigger: 'blur'},
          ],
          keySecret: [
            {required: true, message: '请填写keySecret', trigger: 'blur'},
          ],
          bucketName: [
            {required: true, message: '请填写bucketName', trigger: 'blur'},
          ],
          catalogue: [
            {required: true, message: '请填写目录路径', trigger: 'blur'},
          ],
        },

      }
    }
  }
</script>

<style>
  .common-width {
    /*width: 500px;*/
  }
</style>
