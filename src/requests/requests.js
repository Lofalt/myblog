// import axios from 'axios'
import qs from 'qs'
import {baseURL} from "../../api.config";

axios.defaults.baseURL = baseURL

export const request = function(config)
{
  const instance  = axios.create()

  return instance(config)
}

export const post = function(url,data)
{

  const instance = axios.create(
    {
      headers: {'content-type': 'application/x-www-form-urlencoded'}
    }
  )

  return instance.post(url,qs.stringify(data))

}

export const del =  function(url,config)
{
  const instance = axios.create(
    {
      headers: {'content-type': 'application/x-www-form-urlencoded'}
    }
  )

  return instance.delete(url,config)

}