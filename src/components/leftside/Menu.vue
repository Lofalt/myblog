<template>
    <div class="menu">
        <ul>
            <li :class="{underline:1==currentIndex}"><a href="javascript:" @click="change(1,'/home')">首页</a></li>
            <li @click="showMenu(2)" :class="{underline:2==currentIndex}"><a href="javascript:"  >文章归档</a></li>
            <menu-collapse>
            <ul v-show="currentIndex == 2 && isActive" class="secondmenu" ref="secondmenu">
                <li><a href="javascript:" @click="jump('all')">全部分类</a></li>
                <li v-for="item in categoryList"><a href="javascript:" @click="jump(item.categoryId)">{{item.categoryName}}</a></li>
            </ul>
            </menu-collapse>
            <li  :class="{underline:3==currentIndex}"><a href="javascript:" @click="message">吃我安利</a></li>
            <li :class="{underline:4==currentIndex}"><a href="javascript:" @click="change(4,'/messages')" >留言板</a></li>
            <li :class="{underline:5==currentIndex}"><a href="javascript:" @click="change(5,'/about')" >关于我</a></li>
        </ul>
<!--        <div class="logout">-->
<!--            <el-popconfirm-->
<!--                    title="确认要注销吗?"-->
<!--            >-->
<!--                <el-button  type='danger' slot="reference" @click="logout">注销</el-button>-->
<!--            </el-popconfirm>-->
<!--        </div>-->
    </div>

</template>

<script>
  import {request} from '../../requests/requests'
  import MenuCollapse from '../../util/menuCollapse'
  import scrollToTop from "../../util/scrollToTop";
  export default {
    name: "Menu",
    components:{
      MenuCollapse
    },
    data(){
      return {
        currentIndex:0,
        menuIsActive:false,
        trueHeight:'',
        items:[1,2,3,4,5],
        isActive :false,
        categoryList:''
      }
    },
    methods:{
      change(index,path){
        this.currentIndex = index;
        if(path && path!=this.$route.path) {
          this.$router.push(path)
          this.$emit('hidemenu')
          scrollToTop(500)
        }
      },
      message(){
        this.$message.warning('别点啦,点不进去的,想看的话自己在地址栏后面加/anli试试?')
      },
      showMenu(index,path){
        if(index==this.currentIndex && this.isActive) {
          this.isActive = false
        }else{
          this.change(index,path)
          this.isActive = true
        }
      },
      jump(categoryId,index){
        if(this.$route.params.categoryId!=categoryId) {
          this.$router.push("/article/" + categoryId)
          this.$emit('hidemenu')
          scrollToTop(500)
        }
      },
      logout(){
        localStorage.removeItem('token')
        this.$store.commit('updateToken',null)
        this.$store.commit('updateUsername',null)
        // if(localStorage.getItem('prePath')){
        //   location.href= localStorage.getItem('prePath')
        // }else{
        //   location.href = '/home'
        // }
        location.href = this.$route.path
      }
    },
    created() {
      request('/category').then((result)=>{
        this.categoryList = result.data
      })
    }
  }
</script>

<style  lang="less" scoped>
    .menu{
        margin-top:50px;
        position: relative;
        margin-left: 10px;
        margin-right: 10px;
         &>ul>li{
             border-radius:20px;
            width: 100%;
            text-align: center;
            list-style-type: none;
            font-size: 1em;
            margin-bottom:10px;
             border-bottom: rgba(#fff, .3) 5px inset;

             padding-top: 10px;
            padding-bottom: 10px;
            box-shadow:-1px 1px 5px rgba(180, 222, 182, 0.5);
             &:nth-of-type(3){
                &:hover{
                    border-bottom: #8c939d 5px solid;
                }
                 a:link{
                     color: #8c939d;
                    cursor: default;
                 }
             }
             &:hover{
                 border-bottom: rgb(255, 183, 181) 5px solid;
             }
        }
        .underline{
            border-bottom: rgb(255, 183, 181) 5px solid;


        }
        .showmenu{
            display: none;
        }

        a {
            &:hover::before {
                left: -10%;
                opacity: 1;
            }

            &:hover::after {
                right: -10%;
                opacity: 1;
            }

            &::before {
                content: '\007C';
                position: relative;
                left: -5%;
                transition: .5s ease;
                opacity: 0;
                font-size: 1.15em;

            }

            &::after {
                content: '\007C';
                position: relative;
                right: -5%;
                transition: .5s ease;
                opacity: 0;
                font-size: 1.15em;
            }
        }
        a:link,a:visited{
        text-decoration: none;
        color: #ffa74b;
        font-family: "微软雅黑 Light";
        font-weight: bolder;
    }
        .secondmenu{
            border-radius:20px;
            background-color: #ffc48c;
            margin-top:-10px;
            margin-bottom: 10px;
            transition: .5s ease all;
            overflow:hidden;
            width: 100%;
            text-align: center;
            list-style-type: none;
            /*display: none;*/
            li{
                margin:10px 60px;
                padding-bottom: 5px;
                border-bottom: white 3px solid;
                a{
                    font-weight: normal;
                    color: white;
                }
            }
        }
    }
</style>