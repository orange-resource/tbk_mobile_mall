<template>

  <div>

    <orange-operation-card>

      <div slot="operation" style="display: inline">
        <span @click="openExpress" style="color: #409EFF;cursor: pointer;margin-left: 20px"> 上一页</span>
      </div>

      <div slot="form">
        <el-form :model="form" :rules="forms" :status-icon="true"
                 ref="form" label-width="100px" class="demo-ruleForm">

          <el-form-item label="版本号" prop="number">
            <el-input v-model="form.number" class="common-width"></el-input>
          </el-form-item>

          <el-form-item label="更新公告(日志)" prop="notice">
            <el-input
              v-model="form.notice"
              class="common-width"
              type="textarea"
              :rows="15"
              placeholder="请输入更新公告"
            >
            </el-input>
          </el-form-item>

          <el-form-item label="更新地址" prop="updateUrl">
            <el-input v-model="form.updateUrl" class="common-width"></el-input>
          </el-form-item>

          <el-form-item label="是否强制更新" prop="novatioNecessaria">
            <el-radio-group v-model="form.novatioNecessaria" size="medium">
              <el-radio border :label=0 >不强制</el-radio>
              <el-radio border :label=1 >强制</el-radio>
            </el-radio-group>
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
          number: '',
          notice: '',
          novatioNecessaria: 0,
          updateUrl: '',
        },
        forms: {
          number: [
            {required: true, message: '请填写版本号', trigger: 'blur'},
          ],
        },
      }
    },
    methods: {
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

</style>
