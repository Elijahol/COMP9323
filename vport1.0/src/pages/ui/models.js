import React from 'react'
import {Card, Button, Radio, Modal} from 'antd'
import './ui.less'

export default class Models extends React.Component {
    state = {
        'showModal1': false
    }
    handleOpen = (type) => {
        // switch(type){
        //     case 'showModel1':
        //         this.setState({
        //             'showModal1': true
        //     })
        //     default: break
        // }
        this.setState({
            [type]: true
        })
    }
    handleConfirm = (type) => {
        Modal[type]({
            title: 'Confirm',
            content: 'Are u sure?',
            onOk(){
                console.log('ok')
            },
            onCancel(){
                console.log('cancel')
            }
        })
    }

    render() {
        return (
            <div>
                <Card title="basic models" className='card-wrap'>
                    <Button type='primary' onClick={() => this.handleOpen('showModal1')}>Open</Button>
                    <Button type='primary' onClick={() => this.handleOpen('showModal2')}>Custom footer</Button>
                    <Button type='primary' onClick={() => this.handleOpen('showModal3')}>top20px</Button>
                    <Button type='primary' onClick={() => this.handleOpen('showModal4')}>v-Center</Button>
                </Card>
                <Card title="confirm information" className='card-wrap'>
                    <Button type='primary' onClick={() => this.handleConfirm('confirm')}>Open</Button>
                    <Button type='primary' onClick={() => this.handleConfirm('success')}>Custom footer</Button>
                    <Button type='primary' onClick={() => this.handleConfirm('warning')}>top20px</Button>
                    <Button type='primary' onClick={() => this.handleConfirm('info')}>v-Center</Button>
                </Card>
                <Modal
                    title='React'
                    visible={this.state.showModal1}
                    onCancel={() => {
                        this.setState({
                            showModal1: false
                        })
                    }}
                >
                    <p>Welcome</p>
                </Modal>
                <Modal
                    title='React'
                    visible={this.state.showModal2}
                    okText='Next'
                    cancelText='Cancel'
                    onCancel={() => {
                        this.setState({
                            showModal2: false
                        })
                    }}
                >
                    <p>Welcome</p>
                </Modal>

            </div>
        )
    }
}