import {request} from "../requests/requests";
import {post} from "../requests/requests";

export default function (token,that) {
    request(
      {
        url:'/tokenValid',
        params:{
          token:token
        }
      }
    ).then((result)=>{
      if(result.data.user!=null){
        that.user = result.data.user
        console.log(that)
      }
    })
}