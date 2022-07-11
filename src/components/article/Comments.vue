<template>
    <div class="comments">
        <div  class="commentTitle">
            评论区
        </div>
        <div v-if="comments && comments.length!=0">
            <comment :index="index" v-for="(comment,index) in comments" :comment="comment" :key="comment.commentId" @reloadComment="reload"/>
        </div>
        <div class="commentMessage" v-else>
            <span style="font-size: 17px">还没有评论噢!赶紧留言吧!</span>
        </div>
        <submit-comment v-if="article" :article-id="article.articleId" @reloadComment="reload"/>
    </div>
</template>

<script>
    import Comment from "./Comment";
    import SubmitComment from "./SubmitComment";
    import {request} from "../../requests/requests";
    export default {
    name: "Comments",
    components:{
      Comment,
      SubmitComment
    },
    props:['article'],
    data(){
      return {
        comments:null
      }
    },
      methods:{
        reload(){
          request('/comment/'+this.article.articleId).then((result) => {
            this.comments = result.data
          })
        }
      },
    watch: {
      'article'(to, from) {
        if(this.article) {
          request('/comment/' + this.article.articleId).then((result) => {
            this.comments = result.data
          })
        }
      }
    }
  }
</script>

<style lang="less" scoped>
    .commentTitle{
        font-size: 18px;
        font-weight: bold;
        padding-bottom: 10px;
        margin:0 50px;
        border-bottom: white 3px solid;
    }
    .commentMessage{
        margin:5px 50px;
    }

    @media screen and(max-width: 800px){
        .commentTitle{
            margin: 0 5px;
        }
        .comments{
            margin: 0 5px;
        }
        .commentMessage{
            margin:5px 5px;
        }

    }
</style>