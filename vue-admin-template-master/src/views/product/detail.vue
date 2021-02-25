<template>
  <div class="app-container">
    <div class="box">
      <p>{{product.name}} </p>
      <p>{{product.content}}</p>
      <p>price:{{product.price/100}} <el-link type="danger" @click="editProduct(product.id)">edit</el-link></p>
      <p>freight:{{product.freight/100}}</p>
    </div>
    <div class="box" v-for="item in list">
      <p>
        <el-link type="info"  :href="item.url" target="_blank" >{{item.name}}</el-link>
      </p>
      <p>{{item.content}}</p>
      <p>price:{{item.price/100}}</p>
      <p>freight:{{item.freight/100}}</p>
      <p>platform:{{item.platform}}</p>
      <p>
        <el-link type="danger" @click="deleteRef(item.id)">delete</el-link>

      </p>
    </div>


  </div>
</template>

<script>
  import { add,update,detail } from '@/api/product'
  import { addRef,updateRef,deleteRef } from '@/api/product_ref'

  export default {
    data() {
      return {
        product: {
          name: '',
          content: '',
          price:0,
          freight:0
        },
        list:[]
      }
    },
    mounted(){
      let t = this;
      detail({id:this.$route.query.id}).then((data)=>{
        let d = data.data;
        t.product = d.product;
        t.list = d.list;
      })
    },
    methods: {
      onSubmit() {
        detail(this.form).then(()=>{
          this.$message('submit!')
        })

      },
      deleteRef(id){
        deleteRef({id:id}).then(()=>{
          this.$message('submit!')
        })
      },
      editProduct(id){
        this.$router.push({ path: '/product/update?id='+id });
      }
    }
  }
</script>

<style scoped>
  .box{
    border: 1px solid #c0c0c0;
    margin: 10px 0;
  }
</style>

