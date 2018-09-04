import React from 'react'
import { Card, Button, notification } from 'antd'
import './ui.less'
export default class Notifications extends React.Component{

    openNotification = (type)=>{
        notification[type]({
            message: "wechat message",
            description: 'Are u willing to have dinner with me tonight?'
        })
    }

    render(){
        return (
            <div>
                <Card title='notification' className='card-wrap'>
                    <Button type='primary' onClick={()=>this.openNotification('success')}>Success</Button>
                    <Button type='primary' onClick={()=>this.openNotification('info')}>info</Button>
                    <Button type='primary' onClick={()=>this.openNotification('warning')}>warning</Button>
                </Card>
            </div>
        )
    }
}