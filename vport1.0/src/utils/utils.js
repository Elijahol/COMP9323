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
<<<<<<< HEAD
    if (role === 1){
=======
    if (role === '1'){
>>>>>>> bc13db4712343d0e929d89d830e3507f79e60355
        console.log('正在跳往教练主页');
        return '/trainerMain'
    } else{
        return '/stuMain'
    }

}