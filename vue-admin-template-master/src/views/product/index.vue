<template>
  <div class="app-container">
    <el-table
      v-loading="listLoading"
      :data="list"
      element-loading-text="Loading"
      border
      fit
      highlight-current-row
    >
      <el-table-column align="center" label="ID" width="95">
        <template slot-scope="scope">
          {{ scope.$index }}
        </template>
      </el-table-column>
      <el-table-column label="Title">
        <template slot-scope="scope">
          {{ scope.row.name }}
        </template>
      </el-table-column>
      <el-table-column label="price" width="110" align="center">
        <template slot-scope="scope">
          <span>{{ scope.row.price/100 }}</span>
        </template>
      </el-table-column>
      <el-table-column label="freight" width="110" align="center">
        <template slot-scope="scope">
          {{ scope.row.freight/100 }}
        </template>
      </el-table-column>
      <el-table-column align="center" label="operation" width="200">
        <template slot-scope="scope">
          <el-button type="text" size="mini" @click.stop="deleteProduct(scope.row.id)" >delete</el-button>
          <el-button type="text" size="mini" @click.stop="openDetail(scope.row.id)" >detail</el-button>
          <el-button type="text" size="mini" @click.stop="addRef(scope.row.id)" >ref</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
  import { getList,deleteProduct } from '@/api/product'

  export default {
    filters: {
      statusFilter(status) {
        const statusMap = {
          published: 'success',
          draft: 'gray',
          deleted: 'danger'
        }
        return statusMap[status]
      }
    },
    data() {
      return {
        list: null,
        listLoading: true
      }
    },
    created() {
      this.fetchData()
    },
    methods: {
      fetchData() {
        this.listLoading = true
        getList().then(response => {
          this.list = response.data.items
        this.listLoading = false
      })
      },

      openDetail(id){
        this.$router.push({ path: '/product/detail?id='+id });
      },
      addRef(id){
        this.$router.push({ path: '/product/add_ref?id='+id });
      },
      deleteProduct(id){
        deleteProduct({id:id}).then(()=>{
          this.$message('submit!')
        })
      }

    }
  }
</script>
