import request from '@/utils/request'

export function getList(params) {
  return request({
    url: '/product_ref/list',
    method: 'get',
    params
  })
}

export function addRef(params) {
  return request({
    url: '/product_ref/add',
    method: 'post',
    // params:params,
    data:params,
    headers: {
      'Content-Type': 'application/json; charset=UTF-8'
    },
    transformRequest: [function(data) {
      // console.log("transformRequest",data)
      data = JSON.stringify(data)
      // console.log(data)
      return data
    }]
  })
}


export function updateRef(params) {
  return request({
    url: '/product_ref/update',
    method: 'post',
    data:{
      name:"xxx"
    }

  })
}


export function detailRef(params) {
  return request({
    url: '/product_ref/detail',
    method: 'get',
    params
  })
}

export function deleteRef(params) {
  return request({
    url: '/product_ref/delete',
    method: 'post',
    params
  })
}
