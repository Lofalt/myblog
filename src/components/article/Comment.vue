<template>
    <div class="comment">
<!--            {{comment.commentId}}-->
<!--            {{comment.commentArticleId}}-->
        <div class="commentHeader">
            <span>
                #{{index+1}}
            </span>
            用户: {{comment.commentUserName}}
            发表于: {{comment.commentCreateTime}}
            <a v-if="$store.state.user && $store.state.user.isAdmin" href="javascript:" @click="del(comment.commentId)">删除留言</a>
        </div>
        <div  class="commentContent">
<!--            {{comment.commentContent}}-->
            <div v-html="comment.commentContent"/>
            <div v-if="comment.commentChild" class="child comment">
                <div class="commentHeader" style="{margin-left:40px;}">
                    博主回复:
                    发表于: {{comment.commentChild.commentCreateTime}}
                </div>
                <div v-html="comment.commentChild.commentContent" class="commentContent"/>
            </div>
        </div>
    </div>
</template>

<script>
    import {del} from "../../requests/requests";

    export default {
    name: "Comment",
    props:['comment','index'],
      computed:{

      },
      methods:{
      del(commentId){
        del("/comment",{

            params:{commentId: commentId}

        }).then((result)=>{
          this.$emit('reloadComment')
        })
      },
        isAdmin(){
          return !!(this.$store.state.user && this.$store.state.user.isAdmin);
        }
      }
  }
</script>

<style lang="less" scoped>
    .comment{
        border-radius:5px;
        font-size: 16px;
        margin:5px 50px;
        min-height: 100px;
        /*background-color: #fff;*/
        padding:25px;
        padding-bottom: 10px;
        /*border:5px solid #ff9b99;*/
        /*box-shadow: 0 0 3px rgba(100,100,100,.5);*/
        .child{
            margin-top:10px;
            margin-left:20px;
            margin-bottom: -30px;
            padding-bottom: 0;
            .commentHeader{
                padding-bottom: 5px;
                color: #ff9b99;
            }
        }
        .commentHeader{
            width:100%;
            padding-bottom:20px;
            border-bottom:1px solid #d5d5d5;
            color: #9f9f9f;
        }
        .commentContent{
            font-size: 17px;
            padding-top:10px;
        }

    }

    @media screen and (max-width: 800px){
        .comment{
        margin:20px 0
        }
    }
</style>