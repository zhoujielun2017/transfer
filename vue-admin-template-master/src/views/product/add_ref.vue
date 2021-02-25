<template>
  <div class="app-container">
    <el-form ref="form" :model="form" label-width="120px">
      <el-form-item label="id">
        <el-input v-model="form.productId" />
      </el-form-item>
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
      <el-form-item label="url">
        <el-input v-model="form.url" type="text" />
      </el-form-item>
      <el-form-item label="platform">
        <el-select v-model="form.platform" placeholder="please select your platform">
          <el-option label="tmall" value="tmall" />
          <el-option label="taobao" value="taobao" />
          <el-option label="alibaba" value="alibaba" />
          <el-option label="alimama" value="alimama" />
          <el-option label="jd" value="jd" />
          <el-option label="pdd" value="pdd" />
        </el-select>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="onSubmit">Create</el-button>
        <el-button @click="goDetail(form.productId)">detail</el-button>
        <el-button @click="onCancel">Cancel</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
  import { addRef,updateRef,detailRef } from '@/api/product_ref'

  export default {
    data() {
      return {
        price:{
          price:0,
          freight:0
        },
        form: {
          productId:'',
          name: '',
          content: '',
          price:0,
          freight:0,
          platform:'',
          url:''
        }
      }
    },
    created(){
      this.form.productId=this.$route.query.id;
    },
    methods: {
      onSubmit() {
        this.form.price=this.price.price*100;
        this.form.freight=this.price.freight*100;
        addRef(this.form).then(()=>{
          this.$message('submit!')
        })

      },
      onCancel() {
        this.$message({
          message: 'cancel!',
          type: 'warning'
        })
      },
      goDetail(id){
        this.$router.push({ path: '/product/detail?id='+id });
      }
    }
  }
</script>

<style scoped>
  .line{
    text-align: center;
  }
</style>

