<template>
    <div  class="articlePage" v-cloak>
    <div v-if="article" class="article">
        <div class="articleHeader">
            <div class="articleTitle">
                {{article.articleTitle}}
            </div>
            <div class="articleInfo">
                <span>{{article.articleCreateTime}}</span>
<!--                <span>阅读数:{{article.articleReadTimes}}</span>-->
<!--                <span>点赞:{{article.articleLoveTimes}}</span>-->
<!--                <span>被分享:{{article.articleShareTimes}}</span>-->
            </div>
            <div class="articleSummary">
                <div class="summary">
                {{article.articleSummary}}
                </div>
            </div>
        </div>
        <div class="articleContent" v-html="article.articleContent" v-highlight/>
    </div>
    <div class="preAndNext">
        <div v-if="pre">
            上一篇: <a href="javascript:"  @click="jump(pre.articleId)">{{pre.articleTitle}}</a>
        </div>
        <div v-else disabled>
            该分类下没有上一篇啦!
        </div>
        <div v-if="next" @click="jump(next.articleId)">
            下一篇: <a href="javascript:"  @click="jump(next.articleId)">{{next.articleTitle}}</a>
        </div>
        <div v-else disabled>
            该分类下没有下一篇啦!
        </div>
    </div>
    <comments :article="article" v-cloak/>
    </div>
</template>

<script>
    import {request} from "../requests/requests";
    import scrollToTop from "../util/scrollToTop";
    import Comments from "../components/article/Comments";

    export default {
    name: "Archive",
      components:{
      Comments
      },
    data(){
      return {
        article:null,
        next:null,
        pre:null,
        id:null,
      }
    },
    created() {
      request({
        url:'/archive/'+this.$route.params.articleId
      }).then((result)=>{
        if(!result.data){
          location.href='/404'
        }
        this.article = result.data
        request({
          url: '/archive/preAndNext',
          params:{
            'articleCreateTime':result.data.articleCreateTime,
            'categoryId':result.data.articleCategories[0].categoryId
          }
          }
        ).then((result2)=> {
          this.next = result2.data.next
          this.pre = result2.data.pre
        })
      })
    },
      beforeRouteUpdate(to,from,next){
        request({
          url:'/archive/'+to.params.articleId
        }).then((result)=>{
          this.article = result.data
          request({
              url: '/archive/preAndNext',
              params:{
                'articleCreateTime':result.data.articleCreateTime,
                'categoryId':result.data.articleCategories[0].categoryId
              }
            }
          ).then((result2)=> {
            this.next = result2.data.next
            this.pre = result2.data.pre
          })
        })
        next()
      },
      methods:{
          jump(id){
            scrollToTop(100)
            this.$router.push({
              path:'/archive/'+id,
            }).catch(err=>{})
          },
      },
      watch:{
      '$route'(to,from){
        if(this.$route.params.articleId){
          request({
            url:'/archive/'+this.$route.params.articleId
          }).then((result)=>{
            this.article = result.data
            request({
                url: '/archive/preAndNext',
                params:{
                  'articleCreateTime':result.data.articleCreateTime,
                  'categoryId':result.data.articleCategories[0].categoryId
                }
              }
            ).then((result2)=> {
              this.next = result2.data.next
              this.pre = result2.data.pre
            })
          })
        }
      }
      },
      beforeRouteLeave(to,from,next){
        this.article = null
        next();
      },

  }
</script>

<style lang="less">
    .articlePage{
        /*color: white;*/
        min-height: 1000px;
        width: 100%;
        padding-top:20px;
        background-color: floralwhite;
        font-family: 微软雅黑;
        font-size:20px;

    }
    .article{
        .articleContent{

            *{
                /*margin-top:15px;*/
                font-size:16px;
                padding-bottom:15px;
                color: #032f62;
                /*color: #005cc5;*/
                /*color: #009486;*/
            }
            a img{
                max-width: 100%;
            }
            img{
                max-width: 100%;
            }
            margin-top:20px;
            border-top:1px solid #ffc48c;
        }
        .articleSummary{
            font-size: 17px;
            text-align: center;
            background-color: #ffc48c;
            /*width: 60%;*/
            color:white;
            margin:0 auto;
            min-height: 80px;
            /*padding-top:30px;*/
            box-sizing: border-box;
            margin-top:-30px;
            display: flex;
            padding:20px;
            justify-content: center;
            align-items: center;
            border-radius: 5px;
            /*padding-bottom: 40px;*/
            /*border-bottom: 1px solid black ;*/
            box-shadow: 0 0 2px rgba(100,100,100,.4);
            .summary{

            }
        }
        margin:50px 50px 20px 50px;
        /*margin-bottom: 20px;*/
        /*text-overflow: ellipsis;*/
        /*overflow: hidden;*/
        /*max-height: 190px;*/
        /*background-color: #ffffff;*/
        padding: 30px;
        /*border:5px #ffe4b5 dashed;*/
        /*box-shadow: 0 0 5px rgba(100,100,100,.5);*/
        border-bottom: 1px solid #ffc48c;
        /*border-radius: 10px;*/

    .articleHeader{
    .articleTitle{
        margin-top:10px;
        margin-bottom:20px;
        text-align: center;
        font-size: 30px;
        font-weight:500;
        color: #494a4c;

    }
    .articleInfo{
        text-align: center;
        padding-bottom:10px;
        margin-bottom:50px;
        border-bottom:1px solid #ffc48c;
    span{
        margin-left: 10px;
        font-size: 15px;
        color: #ffc48c;
    }
    }
    }
    }
    .preAndNext{
        display: flex;
        justify-content: space-between;
        margin:0 50px;
        font-size:16px;
        margin-bottom: 20px;
        a{
            text-decoration: none;
            color: #ffb78d;
            text-shadow: 0 0 3px rgba(255, 245, 231, 0.5);
            &:hover{
                color: #ff707f;
            }
        }
    }
    @media screen and (max-width: 800px){
        .preAndNext{
            margin:10px 5px;
        }
        .article{
            height: 100%;
            padding: 10px;
            margin:0 5px;
        }
        .articlePage{
            /*padding:0 10px;*/
            margin:0;
            /*max-width: 100%;*/
        }
    }

    @media screen and (min-width: 800px){

        .articleSummary{
            width: 80%;
        }


    }
</style>