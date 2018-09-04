import React from 'react'
import { Button } from 'antd'
import './index.less'
export default class ThreePic extends React.Component{

    render(){
        return (
            <div className="bg">
                <div className="training-inner">
                    <ul className="training-block">
                        <li><a href="#" className="teenager">
                            <div className="training-detail">
                                <div className="training-title">Teenager</div>
                                <div className="training-population"></div>
                            </div>
                        </a></li>
                        <li><a href="#" className="adult">
                            <div className="training-detail">
                                <div className="training-title">Adult</div>
                                <div className="training-population"></div>
                            </div>
                        </a></li>
                        <li><a href="#" className="customization">
                            <div className="training-detail">
                                <div className="training-title">Customization</div>
                                <div className="training-population"></div>
                            </div>
                        </a></li>
                    </ul>
                    <Button
                        className="course-button"
                        type='primary'
                        ghost={true}
                        icon='plus'
                        size='large'
                    >Course</Button>
                </div>
            </div>
        )
    }
}