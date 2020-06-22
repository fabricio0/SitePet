//homeStyle homeuser

const accordion = document.querySelectorAll('[data-accordion]');
const listaAccordion = document.querySelectorAll('[data-listaAccordion]');

accordion.forEach((item,index) =>{
  item.addEventListener('click', (event) =>{
    item.classList.toggle('ativo');
    listaAccordion[index].classList.toggle('ativo');
  });
});

// function handleabrir(event) {
//   this.classList.toggle('ativo');
// }






const huserAccordionInsert = document.querySelectorAll('[data-accordionInsert]');


const menuLeftHuser = document.querySelectorAll('[data-contentLeft]');

huserAccordionInsert.forEach((item,index) =>{
  item.addEventListener('click', (event) =>{
    menuLeftHuser.forEach((i) =>{
      i.classList.remove('ativo');
    });
    menuLeftHuser[index].classList.add('ativo');
  });
});




















































const DomElemento = document.documentElement;
const body = DomElemento.querySelector('body');
if (body) {
  body.classList.add('js');
}

//validar apenas
const handleAtivaMenu = {
  handleEvent: (event) =>{
    // this.btn = this.btn; fbc
    this.event = event;
    this.menuThis = menu;
    // console.log(this.menuThis);
    this.menuNav = 
    this.menuThis.querySelector('nav');
    this.domElemento = document.documentElement;
    this.ativaMenu = function(){
      if (!this.domElemento.        hasAttribute('menuhandle')) {
        this.domElemento.setAttribute('menuhandle','menuhandle');
        // console.log('oks');
        setTimeout(()=>{
          this.domElemento.addEventListener('click', PositionClick,true);
        });
      }
      this.menuNav.classList.add('ativo');
        // console.log(this.menuNav);
    }
    if (this.event.target == this.menuThis){
      this.ativaMenu();
    }
    this.remove = function(){
      this.menuNav.classList.remove('ativo');
      // console.log('ofss');
      this.domElemento.removeEventListener('click', PositionClick,true);
      this.domElemento.removeAttribute('menuhandle','menuhandle');
    }
    this.PositionClick = (event) =>{
      // console.log(event.target);
      // console.log('énosi');
      this.menuNavUl = 
      this.menuThis.querySelector('nav ul');
      if (!this.menuNavUl.contains(event.target)) {
        this.remove();
      }
    }
    
    
      // console.log(this.menuAtivado);
      // console.log(this.event.target);
      // this.ativaMenu();
  }
}
const menu = document.querySelector('[data-menu]');
// console.log(menu);
// this.btn = 'fbc'; body)
if (menu && body){
  menu.addEventListener('click', handleAtivaMenu);
}













