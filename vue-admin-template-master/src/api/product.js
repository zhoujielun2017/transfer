import request from '@/utils/request'

export function getList(params) {
  return request({
    url: '/product/list',
    method: 'get',
    params
  })
}

export function add(params) {
  return request({
    url: '/product/add',
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


export function update(params) {
  return request({
    url: '/product/update',
    method: 'post',
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


export function detail(params) {
  return request({
    url: '/product/detail',
    method: 'get',
    params
  })
}


export function deleteProduct(params) {
  return request({
    url: '/product/delete',
    method: 'post',
    params
  })
}
