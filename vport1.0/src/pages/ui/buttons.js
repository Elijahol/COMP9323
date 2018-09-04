import React from 'react'
import {Card, Button, Radio} from 'antd'
import './ui.less'

export default class Buttons extends React.Component{

    constructor(){
        super();
        this.state={
            'loading': true
        }
    }

    handleLoading = ()=> {
        if(this.state.loading) {
            this.setState({
                'loading': false
            })
        } else {
            this.setState({
                'loading': true
            })
        }

    }

    handleChange = (e)=>{
        this.setState({
            'size': e.target.value
        })
    }

    render(){
        return(
            <div>
                <Card title="Basic button" className='card-wrap'>
                    <Button type='primary'>Vport</Button>
                    <Button>Vport</Button>
                    <Button type='dashed'>Vport</Button>
                    <Button type='danger'>Vport</Button>
                    <Button disabled>Vport</Button>
                </Card>
                <Card title="img button" className='card-wrap'>
                    <Button type='plus'>Add</Button>
                    <Button icon='edit'>Edit</Button>
                    <Button icon='delete'>Delete</Button>
                    <Button icon='search' >Search</Button>
                    <Button icon='download'>Download</Button>
                </Card>
                <Card title="loading button" className='card-wrap'>
                    <Button type='primary' loading={this.state.loading}>Confirm</Button>
                    <Button loading={this.state.loading} shape='circle'></Button>
                    <Button loading={this.state.loading}>loading</Button>
                    <Button loading={this.state.loading} shape='circle'></Button>
                    <Button onClick={this.handleLoading}>Close</Button>
                </Card>
                <Card title='Button Group'>
                    <Button.Group sty>
                        <Button type='primary' icon='left'>Previous</Button>
                        <Button type='primary' icon='right'>Next</Button>
                    </Button.Group>
                </Card>
                <Card title="button size" className='card-wrap'>
                    <Radio.Group value={this.state.size} onChange={this.handleChange}>
                        <Radio value='small'>small</Radio>
                        <Radio value='default'>medium</Radio>
                        <Radio value='large'>large</Radio>
                    </Radio.Group>
                    <Button type='primary' size={this.state.size}>Vport</Button>
                    <Button type='dashed' size={this.state.size}>Vport</Button>
                    <Button type='danger' size={this.state.size}>Vport</Button>
                    <Button disabled size={this.state.size}>Vport</Button>
                </Card>
            </div>
        )
    }
}