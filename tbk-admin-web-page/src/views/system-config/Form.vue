<template>

  <div>

    <orange-operation-card>

      <div slot="form">
        <el-form :model="form" :rules="forms" :status-icon="true"
                 ref="form" label-width="100px" class="demo-ruleForm">

          <el-form-item label="联系方式" prop="contact">
            <el-input
              type="textarea"
              :rows="5"
              placeholder="请输入内容"
              v-model="form.contact">
            </el-input>
          </el-form-item>
          <el-form-item label="关于我们" prop="about">
            <el-input
              type="textarea"
              :rows="5"
              placeholder="请输入内容"
              v-model="form.about">
            </el-input>
          </el-form-item>
          <el-form-item label="网站底部" prop="footer">
            <el-input
              type="textarea"
              :rows="5"
              placeholder="请输入内容"
              v-model="form.footer">
            </el-input>
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

      this.$axios.get("systemConfig/single").then((rsp) => {
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

        let url = "systemConfig/create";

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
          contact: '',
          about: '',
          footer: '',
        },
        forms: {
          contact: [
            {required: true, message: '请填写联系方式', trigger: 'blur'},
          ],
          about: [
            {required: true, message: '请填写关于我们', trigger: 'blur'},
          ],
          footer: [
            {required: true, message: '请填写网站网站底部', trigger: 'blur'},
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
