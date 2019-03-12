<template>

  <div>
    <el-row :gutter="0">

      <el-col :span="24">

        <el-card shadow="always" v-show="searchWorkspace == false" style="text-align: center">
          <i class="el-icon-upload"></i>
          <span> 操作</span>
          <el-button style="float: right; padding: 3px 0" type="text" @click="searchWorkspace = !searchWorkspace">
            展示
          </el-button>
        </el-card>

        <el-card class="box-card" shadow="always" v-show="searchWorkspace == true">
          <div slot="header" class="clearfix">
            <i class="el-icon-upload"></i>
            <span> 操作</span>
            <slot name="operation"></slot>
            <el-button style="float: right; padding: 3px 0" type="text" @click="searchWorkspace = !searchWorkspace">
              收起
            </el-button>
          </div>

          <el-row type="flex" class="row-bg" justify="center">
            <el-col :span="18">
              <slot name="form"></slot>
            </el-col>
          </el-row>

        </el-card>

      </el-col>

    </el-row>

  </div>

</template>

<script>
  export default {
    name: 'orange-operation-card',
    data() {
      return {
        searchWorkspace: true, //收起放下
      }
    },
  }
</script>

<style scoped>

</style>
