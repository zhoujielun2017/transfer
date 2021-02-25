<template>
  <div class="app-container">
    <el-form ref="form" :model="form" label-width="120px">
      <el-form-item label="name">
        <el-input v-model="form.name" />
      </el-form-item>
      <el-form-item label="description">
        <el-input v-model="form.content" type="textarea" />
      </el-form-item>
      <el-form-item label="price">
        <el-input v-model="price.price" type="text" />
      </el-form-item>
      <el-form-item label="freight">
        <el-input v-model="price.freight" type="text" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">Create</el-button>
        <el-button @click="onCancel">Cancel</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
  import { add,update } from '@/api/product'

  export default {
    data() {
      return {
        price:{
          price:0,
          freight:0
        },
        form: {
          name: '',
          content: '',
          price:0,
          freight:0
        }
      }
    },
    methods: {
      onSubmit() {
        this.form.price=this.price.price*100;
        this.form.freight=this.price.freight*100;
        add(this.form).then(()=>{
          this.$message('submit!')
        })

      },
      onCancel() {
        this.$message({
          message: 'cancel!',
          type: 'warning'
        })
      }
    }
  }
</script>

<style scoped>
  .line{
    text-align: center;
  }
</style>

