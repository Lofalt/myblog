// import Vue from 'vue'
// import VueRouter from 'vue-router'


Vue.use(VueRouter)

const routes = [
  {
    path:'',
    redirect:'/home'
  },
  {
    path:'/article',
    redirect:'/article/all'
  },
  {
    path:'/home',
    component:()=>import('../views/Home'),
    meta:{
      title:'首页 | 狗の窝'
    }
  },
  {
    path:'/article/:categoryId',
    component:()=> import('../views/Article'),
    meta:{
      title:'文章归档 | 狗の窝'
    }
  },{
  path:'/about',
    component:()=> import('../views/About'),
    meta:{
      title:'关于我 | 狗の窝'
    }
  },
  {
    path:'/anli',
    component:()=> import('../views/Anli')
  },
  {
    path:'/messages',
    component: ()=> import('../views/Messages'),
    meta:{
      title:'留言板  |  狗の窝'
    }
  },
  {
    path:'/archive/:articleId',
    component:()=> import('../views/Archive')
  },
  {
    path:'*',
    component: (resolve)=>require(['../views/404.vue'],resolve),
    meta:{
      title:'404啦 | 狗の窝'
    }
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})
router.beforeEach((to,from,next)=>{
  if(to.meta.title){
    document.title = to.meta.title
  }
  next()
})


export default router
