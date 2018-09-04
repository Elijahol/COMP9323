import JsonP from 'jsonp'
import {Modal} from 'antd'
import axios from 'axios'
export default class Axios{
    static jsonp(options){
        return new Promise((resolve, reject)=>{
            JsonP(options.url, {
                param: 'callback'
            }, function(err, response){
                // to-do
                if(response.status === 'success'){
                    resolve(response);
                }else{
                    reject(err.message);
                }
            })
        })
    }

    static ajax(options){
        let baseApi = 'https://www.easy-mock.com/mock/5b7f79c74a96987699e4061b/example';
        return new Promise((resolve, reject) => {
            axios({
                url: options.url,
                method: 'get',
                baseURL: baseApi,
                timeout: 5000,
                params: (options.data && options.params) || ''
            }).then((response)=>{
                if(response.status == '200'){
                    let res = response.data;
                    if(res.code == '0'){ // 这个code是业务层面定义的(后端返回的)
                        resolve(res)
                    }else{
                        Modal.info({
                            title: 'Notification',
                            content: res.msg
                        })
                    }
                }else{
                    reject(response.data);
                }
            })
        })
    }
}