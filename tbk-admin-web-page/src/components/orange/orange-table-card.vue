<template>

  <div id="app">

    <!--搜索操作区-->
    <!-- gutter = 间距(控制每块col间距大小)-->
    <el-row v-if="isShowSearch == true" :gutter="0">

      <el-col :span="24" style="margin-top: 10px">

        <el-card v-show="searchWorkspace == false" shadow="always">
          <i class="el-icon-search"/>
          <span> 搜索</span>
          <el-button style="float: right; padding: 3px 0" type="text" @click="searchWorkspace = !searchWorkspace">
            展示
          </el-button>
        </el-card>

        <el-card v-show="searchWorkspace == true" class="box-card" shadow="always">
          <div slot="header" class="clearfix">
            <i class="el-icon-search"/>
            <span> 搜索</span>
            <el-button style="float: right; padding: 3px 0" type="text" @click="searchWorkspace = !searchWorkspace">
              收起
            </el-button>
          </div>

          <!--搜索-->
          <slot name="search"></slot>

        </el-card>

      </el-col>

    </el-row>

    <!--表格展示(操作)区-->
    <el-row :gutter="0">

      <el-col :span="24" style="margin-top: 10px">

        <el-card v-show="workingArea == false" shadow="always">
          <i class="el-icon-edit"/>
          操作
          <el-button style="float: right; padding: 3px 0" type="text" @click="workingArea = !workingArea">
            展示
          </el-button>
        </el-card>

        <el-card v-show="workingArea" class="box-card" shadow="always">
          <div slot="header" class="clearfix">
            <i class="el-icon-edit"/>
            <span> 操作</span>
            <!--操作区-->
            <slot name="operation"></slot>
            <el-button style="float: right; padding: 3px 0" type="text" @click="workingArea = !workingArea">
              收起
            </el-button>
          </div>

          <!--按钮操作区-->
          <slot name="btn"></slot>

          <!--表格展示区-->
          <slot name="table"></slot>

        </el-card>

      </el-col>

    </el-row>

  </div>

</template>

<script>
  export default {
    name: 'orange-table-card',
    props:["isShowSearch"],
    data() {
      return {
        // 控制两块区域是否显示
        searchWorkspace: true,
        workingArea: true,
      }
    }
  }
</script>

<style scoped>

</style>
