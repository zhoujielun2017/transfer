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
        <el-button @click="goDetail(form.id)">detail</el-button>
        <el-button @click="onCancel">Cancel</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
  import { add,update,detail } from '@/api/product'

  export default {
    data() {
      return {
        price:{
          price:0,
          freight:0
        },
        form: {
          id:'',
          name: '',
          content: '',
          price:0,
          freight:0
        }
      }
    },
    mounted(){
      let t = this;
      detail({id:this.$route.query.id}).then((data)=>{
        let d = data.data;
        let p = d.product;
        t.form.id=p.id;
        t.form.name=p.name;
        t.form.content=p.content;
        t.price.price=p.price/100
        t.price.freight=p.freight/100
      })
    },
    methods: {
      onSubmit() {
        this.form.price=this.price.price*100;
        this.form.freight=this.price.freight*100;
        update(this.form).then(()=>{
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

