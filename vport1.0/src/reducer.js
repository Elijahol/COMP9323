// 合并所有reducer并返回
import { combineReducers } from 'redux'
import { user } from './redux/user.redux'
import { trainerMain } from './redux/trainerMain.redux'

export default combineReducers({ user, trainerMain })