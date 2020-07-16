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



//const modalViewUser = document.querySelector('[data-btnFecharView]');







const botaoAbrir = document.querySelectorAll('.data-Modal');
const botaoFechar = document.querySelector('[data-btnFechar]');
const container = document.querySelector('.ModalUsuario');

function handleabrir(event) {
  container.classList.add('ativo');
  setTimeout(()=>{
    cliqueForaContainer.addEventListener('click', handleCliqueFora, true);
  },100);
}
botaoAbrir.forEach(item =>{
	item.addEventListener('click', handleabrir);
})

function handleFechar(event) {
  container.classList.remove('ativo');
  cliqueForaContainer.removeEventListener('click',handleCliqueFora, true);
}
botaoFechar.addEventListener('click', handleFechar);

function handleCliqueFora(event) {
  if (event.target.contains(container)) {
    handleFechar();
  }
  console.log('fds');
  
  console.log(event.target);
  console.log(container);
  
  // console.log(event.target.contains(container));
  
}
const cliqueForaContainer = document.documentElement;






































const DomElemento = document.documentElement;
const body = DomElemento.querySelector('body');
if (body) {
  body.classList.add('js');
}
const dataScroll = document.querySelectorAll('.js [data-href]');
const tipoDeClique = ['click', 'touchStart'];

if (body && dataScroll) {
  dataScroll.forEach(imgNode => {
    tipoDeClique.forEach(tipoClique => {
      imgNode.addEventListener(tipoClique, handleScroll);
    })
  });
}
function handleScroll(event) {
  const atributoScroll = this.getAttribute('data-href');
  const atributoSelecionado = document.querySelector(atributoScroll);
  const distanciaElemento = atributoSelecionado.offsetTop;
  //  atributoSelecionado.scrollIntoView({block: "center", behavior: "smooth"});
  window.scrollTo({
    behavior: 'smooth',
    top: distanciaElemento - 75
  });
}
































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













