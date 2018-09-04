import React from 'react'
import Courses from './../../components/Courses'
import './index.less'
export default class Home extends React.Component{
    render(){
        return(
            <div className="home-wrap">
                <div className="video-wrap">
                    <video src="/assets/vport.webm" loop='loop' autoPlay="autoplay"
                           muted></video>
                    <div className="slogon">
                        Training, as you wish.
                    </div>
                </div>
                <div className="ad" style={{height: 307, textAlign: 'center'}}>
                    <div className="slogon">
                        <h1>Professtional plan & Scientific advise</h1>
                        <p>Designed for different ages, optimized by the new approach to the individual customization.</p>
                    </div>

                </div>
                <Courses></Courses>
            </div>
        )
    }
}