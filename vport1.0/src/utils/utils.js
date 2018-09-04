export default {
    formatDate(date){
        if(!date) return '';
        let opt = new Date(date);
        return `${opt.getFullYear()}-${opt.getMonth()+1}-${opt.getDate()} ${opt.getHours()}:${opt.getMinutes()}:${opt.getSeconds()}`;
    }
}

export function getRedirectPath(role) {
    // 根据用户信息，返回跳转地址
    // user.type /student /trainer
    // user.avatar /bossinfo /geniusinfo
    // let url = (type=='trainer')?'/trainer':'student';
    // 没头像，就去完善信息
    if (role === '2'){
        console.log('正在跳往教练主页');
        return '/trainerMain'
    } else{
        return '/stuMain'
    }

}