import axios from 'axios'
import {getRedirectPath} from "../utils/utils";

const REGISTER_SUCCESS = 'REGISTER_SUCCESS';
const LOGIN_SUCCESS = 'LOGIN_SUCCESS';
const UPDATE_USER_SUCCESS = 'UPDATE_USER_SUCCESS';
const ERROR_MSG = 'ERROR_MSG';
const LOAD_DATA = 'LOAD_DATA';
const DEL_MSG = 'DEL_MSG';
const LOGOUT_SUCCESS = 'LOGOUT_SUCCESS';

const initState = {
    msgCode:'',
    code:'',
    redirectTo:'',
    isAuth:false,
    msg:'',
    name:'',
    email:'',
    password:'',
    role:'',
    phone:'',
    award:'',
    birthday:'',
    city:'',
    gender:'',
    experience:'',
    height:'',
    icon:'',
    id:'',
    status:'',
    weight:''


}
//reducer
export function user(state=initState, action) {
    switch (action.type){
        case REGISTER_SUCCESS:
            return {...state, code:1, msg:'Register Success', isAuth:true, redirectTo:'/login'};
        case LOGIN_SUCCESS:
            return {...state, msgCode:1, msg:'登陆成功', isAuth:true, redirectTo:getRedirectPath(action.payload.role), ...action.payload};
        case UPDATE_USER_SUCCESS:
            return {...state, code:1, msg:'Your profile has been updated', isAuth:true, redirectTo:'/profile', ...action.payload};
        case LOGOUT_SUCCESS:
            return {...state, code: 1};
        case LOAD_DATA:
            return {...state, ...action.payload};
        case ERROR_MSG:
            return {...state, msgCode:0, isAuth:false, msg:action.msg};
        case DEL_MSG:
            return {...state, msg:''};
        default:
            return state
    }
}

// 这是action creator
function registerSuccess(data) {
    return {type:REGISTER_SUCCESS, payload:data}
}
function loginSuccess(data) {
    return {type:LOGIN_SUCCESS, payload:data}
}
function logoutSuccess() {
    return {type:LOGOUT_SUCCESS}
}
// function loadData(data) {
//     return {type:LOAD_DATA, payload:data}
// }
function errorMsg(msg) {
    return {type: ERROR_MSG, msg:msg}
}
function updateUserSuccess(data) {
    return {type:UPDATE_USER_SUCCESS, payload:data}
}

// 这是action
export function register({name, email, password, role}) {
    if(!name||!password) {
        return errorMsg('Please input name/password')
    }
    // if(password!==repeatpassword){
    //     return errorMsg('password not same')
    // }
    return dispatch=>{
        axios.post('/rest/user/register', {name, email, password, role}).then(
            res=>{
                if(res.status==200 && res.data.code == 0){
                    dispatch(registerSuccess({name, email, password, role}))
                }else{
                    dispatch(errorMsg(res.data.msg))
                }
            }
        )
    }
}



export function login({email, password}) {
    console.log('我在redux这里');
    return dispatch=>{
        axios.post('/rest/user/login', {email, password}).then(
            res=>{
                if(res.status==200 && res.data.code==0){
                    dispatch(loginSuccess(res.data.data[0]))  // 交给dude要写成data[0]
                }else{
                    dispatch(errorMsg(res.data.msg))
                }
            }
        )
    }
}
// 更新用户profile(不包括头像)
export function updateUser({ id, birthday, name, address, city, phone, gender, height, weight, award, experience}) {
    // if(password!==repeatpassword){
    //     return errorMsg('password not same')
    // }
    return dispatch=>{
        axios.post('/rest/user/updateUser', { id, birthday, name, address, city, phone, gender, height, weight, award, experience}).then(
            res=>{
                if(res.status == 200 && res.data.code == 0){
                    dispatch(updateUserSuccess({ id, birthday, name, address, city, phone, gender, height, weight, award, experience}))
                }else{
                    dispatch(errorMsg(res.data.msg))
                }
            }
        )
    }
}
// 用户登出请求后端更改cookie
export function logout() {
    return dispatch=>{
        axios.get('/rest/user/logout').then(
            res=>{
                if(res.status===200 && res.data.code === 0){
                    dispatch(logoutSuccess())
                }else{
                    dispatch(errorMsg(res.data.msg))
                }
            }
        )
    }
}

export function loadData(data) {
    return {type:LOAD_DATA, payload:data[0]}  // dude要加0
}
export function delMsg() {
    console.log('正在清除msg...');
    return {type: DEL_MSG}
}