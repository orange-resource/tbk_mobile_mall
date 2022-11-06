<template>

  <div>

    <orange-table-card isShowSearch="true">

      <div slot="search">
        <el-form :inline="true" :model="seachForm" class="demo-form-inline" @submit.native.prevent>
          <el-form-item label="消息标题">
            <el-input v-model="seachForm.title" placeholder="消息标题" clearable @keyup.enter.native="search"/>
          </el-form-item>
          <el-form-item label="消息内容">
            <el-input v-model="seachForm.content" placeholder="消息内容" clearable @keyup.enter.native="search"/>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="search">查询</el-button>
          </el-form-item>
        </el-form>
      </div>

      <div slot="operation" style="display: inline">
        <span style="color: #409EFF;cursor: pointer;margin-left: 20px" @click="search(true)">刷新数据</span>
      </div>

      <div slot="btn">
        <el-button type="primary" @click="openForm"><i class="el-icon-plus"/> 添加</el-button>
      </div>

      <div slot="table">
        <el-table
          :data="table.tableData"
          border
          style="width: 100%;margin-top: 10px">
          <el-table-column
            prop="createDate"
            label="创建时间"
            align="center"
          />
          <el-table-column
            prop="updateDate"
            label="更新时间"
            align="center"
          />
          <el-table-column
            prop="image"
            label="主图"
            align="center"
          >
            <template slot-scope="scope">
              <img style="height: 150px;" :src="scope.row.image" />
            </template>
          </el-table-column>
          <el-table-column
            prop="title"
            label="系统消息标题"
            align="center"
          />
          <el-table-column
            prop="author"
            label="作者"
            align="center"
          />
          <el-table-column
            align="center"
            label="操作"
            width="200">

            <template slot-scope="scope">
              <el-button type="text" size="small" @click="updateRow(scope.row)">编辑</el-button>
              <el-button type="text" size="small" style="color: red" @click="removeRow(scope.row)">删除</el-button>
            </template>

          </el-table-column>
        </el-table>

        <!--分页-->
        <el-pagination
          :page-sizes="table.tablePageSizes"
          :page-size="table.tablePageSize"
          :total="table.tableTotal"
          style="margin-top: 15px"
          background
          layout="total, sizes, prev, pager, next, jumper"
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"/>
      </div>

    </orange-table-card>

  </div>

</template>

<script>

  var time = require('@/utils/time.js');

  export default {
    name: 'List',
    mounted() {
      this.getTableData();
    },
    data() {
      return {

        seachForm: {
          title: '',
          content: '',
        },
        table: {
          tableTotal: 0,
          tableData: [],
          tablePageNum: 1,
          tablePageSize: 10,
          tablePageSizes: [10, 50, 100, 200]
        },
        open: {
          url: 'SystemMessageForm',
        }

      }
    },
    methods: {
      openForm(params) {
        params = params || {}
        params.id = params.id || null
        this.$router.push({
          name: this.open.url,
          params: params
        })
      },
      getTableData() {

        let data = this.seachForm
        data.current = this.table.tablePageNum
        data.size = this.table.tablePageSize

        this.$axios.get('systemMessage/page', {
          params: data
        }).then((rsp) => {
          this.table.tableTotal = rsp.data.total
          for (let i = 0; i < rsp.data.records.length; i++) {
            rsp.data.records[i].createDate = time.timeStampDate({time:rsp.data.records[i].createDate})
            rsp.data.records[i].updateDate = time.timeStampDate({time:rsp.data.records[i].updateDate})
          }
          this.table.tableData = rsp.data.records
        }).catch((e) => {
          this.$notify.error({
            title: '系统错误',
            message: '发生了未知错误:\n' + e
          });
        })
      },
      handleSizeChange(val) {
        this.table.tablePageSize = val
        this.getTableData()
      },
      handleCurrentChange(val) {
        this.table.tablePageNum = val
        this.getTableData()
      },
      search(isPrompt) {
        if (isPrompt == true) {
          this.$message.success('执行刷新数据成功...')
        } else {
          this.table.tablePageNum = 1;
        }
        this.getTableData()
      },
      updateRow(row) {
        this.openForm({ id: row.id })
      },
      removeRow(row) {
        this.$axios.post('systemMessage/delete', this.$qs.stringify({
          systemMessageId: row.id
        })).then((rsp) => {
          this.getTableData()
          this.$message(rsp.msg)
        }).catch((e) => {
          this.$notify.error({
            title: '系统错误',
            message: '发生了未知错误:\n' + e
          });
        })
      },
    }
  }
</script>

<style scoped>

</style>
