import axios from 'axios'
import {getRedirectPath} from "../utils/utils";

const GETCOURSE_SUCCESS = 'GETCOURSE_SUCCESS';
const TIMELINE_SUCCESS = 'TIMELINE_SUCCESS';
const ERROR_MSG = 'ERROR_MSG';

const initState = {
    isLoading:true,
    courses:[],
    timeLine:[],
    code: ''
}
//reducer
export function trainerMain(state=initState, action) {
    switch (action.type){
        case TIMELINE_SUCCESS:
            return {...state, timeLine: action.payload.data};
        case GETCOURSE_SUCCESS:
            console.log('in reducer!')
            console.log(action.payload.data);
            return {...state, code: '1', courses: action.payload.data};
        case ERROR_MSG:
            return {...state, msgCode:0, isAuth:false, msg:action.msg};
        default:
            return state
    }
}

// 这是action creator

function errorMsg(msg) {
    return {type: ERROR_MSG, msg:msg}
}
function getCourseSuccess(data) {
    return {type: GETCOURSE_SUCCESS, payload:data};
}
function getTimeLineSuccess(data) {

    return {type: TIMELINE_SUCCESS, payload:data};
}

// 这是action

export function getCourses() {
    return dispatch=>{
        axios.get('/rest/course/classInfo').then(
            res=>{
                if(res.status===200 && res.data.code === 0){
                    dispatch(getCourseSuccess(res.data))
                }else{
                    dispatch(errorMsg(res.data.msg))
                }
            }
        )
    }
}
// export function getCourses() {
//     return (
//         axios.post('https://www.easy-mock.com/mock/5b7f7a284a96987699e40630/getCourses').then(
//             res=>{
//                 if(res.status===200 && res.data.code === 0){
//                     getCourseSuccess(res.data)
//                 }else{
//                     errorMsg(res.data.msg)
//                 }
//             }
//         )
//     )
// }

export function getTimeLine() {
    return dispatch=>{
        axios.get('/rest/course/timeTable').then(
            res=>{
                if(res.status===200 && res.data.code === 0){
                    dispatch(getTimeLineSuccess(res.data))
                }else{
                    dispatch(errorMsg(res.data.msg))
                }
            }
        )
    }
}

