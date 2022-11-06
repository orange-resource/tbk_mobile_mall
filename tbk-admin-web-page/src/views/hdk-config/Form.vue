<template>

  <div>

    <orange-operation-card>

      <div slot="form">
        <el-form :model="form" :rules="forms" :status-icon="true"
                 ref="form" label-width="100px" class="demo-ruleForm">

          <el-form-item label="appkey" prop="appkey">
            <el-input v-model="form.appkey" class="common-width"></el-input>
          </el-form-item>
          <el-form-item label="pid(推广位id)" prop="pid">
            <el-input v-model="form.pid" class="common-width"></el-input>
          </el-form-item>
          <el-form-item label="淘宝号名称" prop="tbName">
            <el-input v-model="form.tbName" class="common-width"></el-input>
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

      this.$axios.get("hdkConfig/single").then((rsp) => {
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

        let url = "hdkConfig/create";

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
          appkey: '',
          pid: '',
          tbName: '',
        },
        forms: {
          appkey: [
            {required: true, message: '请填写appkey', trigger: 'blur'},
          ],
          pid: [
            {required: true, message: '请填写推广位pid', trigger: 'blur'},
          ],
          tbName: [
            {required: true, message: '请填写淘宝名称', trigger: 'blur'},
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
