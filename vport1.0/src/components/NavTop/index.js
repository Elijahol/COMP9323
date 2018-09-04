import React from 'react'
import { Row, Col, Menu, Dropdown, Icon } from 'antd'
import { NavLink } from 'react-router-dom'
import { connect } from 'react-redux'
import browserCookie from 'browser-cookies'
import { logout } from "../../redux/user.redux";
import './index.less'

@connect(
    state=>state.user,
    {logout}
)
export default class NavTop extends React.Component{

    constructor(){
        super();
        this.state={
        }
    }

    logOut = ()=>{
        this.props.logout();
        browserCookie.erase('userid');
        window.location.href = window.location.href;
    }

    render(){

        const userMenu = (

            <Menu style={{padding:15, width:100, float:'right'}}>
                <NavLink to="/profile">
                    <Menu.Item>
                        <p>Edit Profile</p>
                    </Menu.Item>
                </NavLink>


                <Menu.Divider/>
                <Menu.Item onClick={this.logOut}>
                    <p>Log out</p>
                </Menu.Item>
            </Menu>
        );

        return(

                <Row className="nav-top">
                    <Col md={1} xs={0}/>
                    <NavLink to="/home">
                    <Col md={3} xs={8}className='logo'>
                        <img src="/assets/vport.png" alt="logo"/>
                    </Col>
                    </NavLink>
                    <Col md={10}></Col>
                    <NavLink to="/courses">
                    <Col md={2} xs={8}className="nav-element">
                        Tennis Course
                    </Col>
                    </NavLink>
                    <NavLink to="/shopping">
                    <Col md={2} xs={8}className="nav-element">
                            Shopping
                    </Col>
                    </NavLink>
                    <NavLink to="/news">
                    <Col md={2} xs={8}className="nav-element">
                            News
                    </Col>
                    </NavLink>

                    {this.props.name?<Dropdown placement="bottomCenter" overlay={userMenu} trigger={['click']}>
                        <div>
                            <Col md={2} className="nav-element"/>
                            <Col md={2} xs={8} >
                                <a className="userInfo">{this.props.name}</a>
                            </Col>
                        </div>
                    </Dropdown>:
                        <div>
                            <NavLink to="/register">
                                <Col md={2} xs={8}className="nav-element">
                                    Sign up
                                </Col>
                            </NavLink>
                            <NavLink to="/login">
                                <Col md={2} xs={8}className="nav-element">
                                    Login
                                </Col>
                            </NavLink>
                        </div>
                    }

                    {/*<NavLink to="/register">*/}
                        {/*<Col md={2} xs={8}className="nav-element">*/}
                            {/*Sign up*/}
                        {/*</Col>*/}
                    {/*</NavLink>*/}
                    {/*<NavLink to="/login">*/}
                    {/*<Col md={2} xs={8}className="nav-element">*/}
                        {/*Login*/}
                    {/*</Col>*/}
                    {/*</NavLink>*/}
                </Row>

        )
    }
}