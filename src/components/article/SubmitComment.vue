<template>
    <div class="submitComment">
        <div class="commitHeader">
            发表评论
        </div>
        <div class="buttons">
        <button class="toggle" @click="isAnonymous = false" :class="{active:!isAnonymous}">用户留言</button>
        <button class="toggle" @click="isAnonymous = true" :class="{active:isAnonymous}">匿名留言</button>
        </div>
        <div v-if="!isAnonymous" class="userCommit commit">
            <div v-if="user">
                用户名: {{user.userName}}
                <el-popconfirm
                        title="确定要注销吗？"
                >
                    <el-button type="danger" slot="reference" @click="logout">注销</el-button>
                </el-popconfirm>
<!--                <textarea v-model="commentContent" placeholder="请输入您的高见噢" @keyup.enter="submitComment">-->
                <textarea v-model="commentContent" placeholder="请输入您的高见噢">
                </textarea>
                <button type="button" @click="submitComment" class="submitBtn">
                    提交
                </button>
            </div>
            <div  v-else>
                <span class="login">你还没登陆!立即</span><a href="javascript:" @click="jump('/access/login')">登陆</a>/<a href="javascript:" @click="jump('/access/register')">注册</a>
            </div>
        </div>
        <div v-else="isAnonymous" class="anonymousCommit commit">
            <textarea v-model="commentContent" placeholder="请输入您的高见噢" @keyup.enter="submitComment">

            </textarea>
                <button type="button" @click="submitComment" class="submitBtn">
                    提交
                </button>
        </div>

    </div>
</template>

<script>

    import {post} from "../../requests/requests";
    import validUser from "../../util/validUser";

    export default {
    name: "SubmitComment",
      props:['articleId'],
    data() {
      return {
        isAnonymous: true,
        commentContent: '',
        user:null,
        timeout:null,
        dogs:['聪明绝顶小二哈','温纯可爱小藏獒','人见人爱小泰迪','我最喜欢西施惠','超绝可爱小甜狗','凶神恶煞小柴犬','不愿意透露姓名的宠物店店主','辛勤的铲屎官','祖国的花朵儿']
      }
    },
      computed:{
        dogName(){
          return this.dogs[Math.floor(Math.random()*this.dogs.length)]
        }
      },
    methods: {
      submitComment() {
        if(this.timeout){
          this.$message.warning('30秒内不能重复提交评论嗷,请稍后再试')
          return
        }
        if(this.commentContent && this.commentContent!='' && this.commentContent.trim()!=''){
        post(
          '/comment',
          {
            commentContent: this.commentContent,
            commentArticleId: this.articleId,
            commentUserName: this.user && !this.isAnonymous? this.user.userName:this.dogName
          }
        ).then((result) => {
          if (result.data.success) {
            this.$emit('reloadComment')
            this.commentContent = ''
            this.timeout = true
            let that = this
            setTimeout(()=>{
              that.timeout = false
            },30000)
          }
        })
      }},
      jump(path) {
        window.localStorage.setItem("prePath", this.$route.path)
        console.log(this.$route.path)
        location.href = path;
      },
      logout(){
        localStorage.removeItem('token')
        this.$store.commit('updateToken',null)
        this.$store.commit('updateUsername',null)
        location.href = this.$route.path
      }
    },
      created() {
          if (this.$store.state.user) {
            this.user =  this.$store.state.user
          } else if (localStorage.getItem('token')) {
            validUser(localStorage.getItem('token'),this)
          }
      }
    }
</script>

<style lang="less" scoped>
    .submitComment{
        /*width: 100%;*/
        margin:0 50px;
        margin-bottom: 20px;

        .commitHeader{
            font-size:20px;
            font-weight: bold;
            margin-top: 20px;
            margin-bottom: 20px;
        }
        .buttons{
            width: 100%;
            border-bottom:1px solid #878787;
        }
        .toggle{
            border:1px solid #878787;
            background-color: rgba(255, 197, 128, 0.76);
            padding:10px;
            color: white;
            font-size: 16px;
            outline: none;

            &:nth-of-type(1){
                border-right: none;
                border-bottom: none;
                border-left: none;
                border-top:none;
                border-top-left-radius: 25px;
                /*border-bottom-left-radius: 5px;*/
            }
            &:nth-of-type(2){
                border-bottom:none;
                border-right: none;
                border-top: none;
                /*border-left: #ede8ea 1px solid;*/
                border-left: none;
                border-top-right-radius: 25px;
                /*border-bottom-right-radius: 5px;*/
            }
            &:hover{
                background-color: #ffad71;
            }
        }
        .active{
            background-color: #ffad71;
        }

        .commit{
            margin-top:10px;
            /*background-color: white;*/
            /*box-shadow: 0 0 3px rgba(100,100,100,.5);*/
            font-size: 15px;
            a:link{
                color: #ff9383
            }

            textarea{
                min-width: 300px;
                min-height: 100px;
                width: 100%;
                box-sizing: border-box;
                float: right;
                padding: 20px;
                font-size: 18px;
                border:none;
                border-radius: 10px;
                font-family: 微软雅黑;
            }
            .submitBtn{
                border-radius: 5px;
                margin-top:10px;
                display: block;
                border:none;
                background-color: #ffc580;
                padding:10px 18px;
                /*margin-left: 240px;*/
                float: left;
                color: white;
                margin-bottom: 20px;
                &:hover{
                    background-color: #ffad71;
                }
            }
        }
    }
    @media screen and (max-width: 800px){
        .submitComment{
            margin:0 5px;
        }
    }


</style>