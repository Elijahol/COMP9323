import React from 'react'
import NavTop from '../../component/navTop'
import Advertisement from '../../component/advertisement'
import './index.less'
import { NavLink, Link } from 'react-router-dom'

export default class Welcome extends React.Component{
    constructor(){
        super();
        this.state={

        }
    }
    render(){
        return(
            <div>
                <NavTop></NavTop>
                {/*<NavLink to='/test'>*/}

                {/*</NavLink>*/}
                {this.props.children}
            </div>
        )
    }
}