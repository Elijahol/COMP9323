import React from 'react'
import { createStore, applyMiddleware, compose } from 'redux'
import thunk from 'redux-thunk'
import { Provider } from 'react-redux'
import {BrowserRouter, Route} from 'react-router-dom'
import App from './App'
import Home from './container/home/index'
import Login from './container/login'
import Register from './container/register'
import AuthRoute from './components/authRoute'

import StuProfile from './container/profile'
import reducers from './reducer'
import './config'


const store = createStore(reducers, compose(
    applyMiddleware(thunk),
    window.devToolsExtension?window.devToolsExtension():f=>f
));

export default class IRouter extends React.Component {
    render() {
        return (
            <Provider store={store}>
                <BrowserRouter>
                    <div>
                    <AuthRoute></AuthRoute>
                    <App>
                        <Route path="/home" component={Home}></Route>
                        <Route path="/login" component={Login}>

                        </Route>
                        <Route path="/register" component={Register}></Route>
                        <Route path="/profile" component={StuProfile}></Route>

                    </App>
                    </div>
                </BrowserRouter>
            </Provider>
        )
    }
}