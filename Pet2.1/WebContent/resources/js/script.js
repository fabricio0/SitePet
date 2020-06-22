const DomElemento = document.documentElement;
const body = DomElemento.querySelector('body');
if (body) {
  body.classList.add('js');
}

let animaLetras = document.querySelector('.js [data-anima-letters]');
if (animaLetras && body) {
  const conteudo = " “ BEM VINDO(A) AO PET ADS IFSP SÂO CARLOS ” ";
  const vtConteudo = conteudo.split('') ;
  let textoAnimado = '';
  vtConteudo.forEach((elemento,index) => {
    setTimeout(()=>{
      textoAnimado = textoAnimado + elemento;
      animaLetras.innerText =     
      textoAnimado;
    }, index * 100);
  });
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




//função que faz o scroll suave
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


//Efeito para o scroll. 
//Funcionamento ao descer o sxroll 
//sera exibido o conteudo

const elementoWiddenScroll = document.querySelectorAll('.js [data-anima-scroll]');
if (body && elementoWiddenScroll) {
    window.addEventListener('scroll', handleHiddenScroll);
}

function handleHiddenScroll(event) {
  elementoWiddenScroll.forEach(elementoParaScroll =>{
    let alturaAtualElemento = elementoParaScroll
    .getBoundingClientRect().top;
    let tamanhoDaTela = window.innerHeight * 0.7;
    if (alturaAtualElemento < tamanhoDaTela) {
      elementoParaScroll.classList.add('ativo');
  }
  });
}




//função animar números
//animação de números dinamicos
function handleNumeros(mutation) {
  observer.disconnect();
  // console.log(mutation[0].target.classList.contains('ativo'));
  const elementoParAnimacao = document.querySelectorAll('.js [data-number]');
  // console.log(elementoParAnimacao);
  elementoParAnimacao.forEach(item =>{
    let incremento = 0;
    let value = +item.innerText;
    for (let index = 0; index <= value; index++) {
      setTimeout(() =>{
        item.innerText = incremento++;
      }, 1250 * Math.random());
    }
    if (incremento > value) {
      item.innerText = value;
    }
});
}

const config = { attributes: true };

const observer = new MutationObserver(handleNumeros);

const numerosCrescente = document.querySelector('.js [data-anima-numeros]');

observer.observe(numerosCrescente, config);



//funçao de clicar na imagem e aparecer o texto referente
function handleContenxt(event) {
  // console.log(event);
}

const imgTotal = document.querySelectorAll('[data-img]');
const contextoImgTotal = document.querySelectorAll('.js [data-contexto]');
contextoImgTotal[0].classList.add('ativo');
imgTotal.forEach((element, index) => {
  element.addEventListener('click',
  ()=>{
    contextoImgTotal.forEach(el => {
      el.classList.remove('ativo');
    });
    contextoImgTotal[index].classList.add('ativo');
  });
});

















































// const btnEntrar = document.querySelectorAll('[data-modal]');

// function abrirModal(event) {
//   const atributoScroll = this.getAttribute('data-modal');
//   const elementoSelecionado = document.querySelector(atributoScroll);
//   this.elementoSelecionados = document.querySelector(atributoScroll);
//   console.log('modal');
//   console.log(elementoSelecionado);
  
//   documentoHtmlPai = document.documentElement;
//   elementoSelecionado.classList.add('ativo');
//   setTimeout(() => {
//     documentoHtmlPai.addEventListener('click',handleFechar);
//   },1000);
// }
// const handleFechar = {
//   handleEvent: (event) => {
//     this.elementoSelecionador = this.elementoSelecionados;
//     console.log(this.elementoSelecionador);
//   }
  
  // const elementoSelecionado = document.querySelector(atributoScroll);
  // console.log('modal');
  // console.log(elementoSelecionado);
  // elementoSelecionado.classList.ativo('ativo');

  
  // const btn = document.querySelector('[data-btnFechar]')
  // console.log(btn);
  
// }

// btnEntrar.forEach(element => {
//   element.addEventListener('click', abrirModal);
// });

// const btnFechar = document.querySelectorAll('[data-btnFechar]');
// btnFechar.forEach(btn =>{
//   btn.addEventListener('click', handleFechar)
// });






const botaoAbrir = document.querySelector('[data-modal]');
const botaoFechar = document.querySelector('[data-btnFechar]');
const container = document.querySelector('.ModalUsuario');

function handleabrir(event) {
  container.classList.add('ativo');
  setTimeout(()=>{
    cliqueForaContainer.addEventListener('click', handleCliqueFora, true);
  },100);
}
botaoAbrir.addEventListener('click', handleabrir);

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




































//essa parte pode ser organizada e arrumar fazer de outro parametros  o menu mobile



// function handleAtivaMenu(event){
//   const thisDivMenu = this;
//   const menuAtivado = 
//   this.querySelector('nav');
// //   console.log('oksd');
// //  console.log(menuAtivado);
// //  console.log(event.target);
 
 
//   if (this == event.target) {
//     menuAtivado.classList.add('ativo');
//     // console.log('oksd');
    
//     const domElementoHtml = document.documentElement;
    // if (!domElementoHtml.hasAttribute('menuhandle')) {
    // domElementoHtml.setAttribute('menuhandle','menuhandle');
    // handleOutSide(event, menuAtivado, domElementoHtml,thisDivMenu);
    // }
//   }


//   //   if (this == event.target) {
//   //     menuAtivado.classList.toggle('ativo');
//   //     console.log('oks');
//   //   }
//   //   console.log(menuAtivado);
//   //   console.log(event);
// }

// function handleOutSide(event, menuAtivado, domElementoHtml,thisDivMenu){
//   // console.log('fiui eu');
//   // console.log(event.target);
//   // console.log(menuAtivado);
    
//   setTimeout(() => {
//     domElementoHtml.addEventListener('click', finalTests);
//   });
//   // console.log(menuAtivado);
//   // console.log(event.target);
// }
// function finalTest(event, menuAtivado, domElementoHtml,thisDivMenu) {
//   console.log('afs');
 
//   console.log(event.target);
//   console.log(thisDivMenu);
//   console.log('oka');
  
    
//   if (event.target == thisDivMenu) {
//     console.log('fbc');

//      removeAttrs();
  
//   } 
// }

// function removeAttrs(menuAtivado, domElementoHtml) {
//   console.log('oks');
  
//   menuAtivado.classList.remove('ativo');
//   domElementoHtml.removeAttribute('menuhandle','menuhandle');
//   menuAtivado.classList.remove('ativo');
//   // domElementoHtml.removeEventListener('click', finalTest);
// }
// function excluirFinal(event, menuAtivado, domElementoHtml) {
//   setTimeout(()=>{
    
//   if (!menuAtivado.contains(event.target)) {
//     domElementoHtml.removeAttribute('menuhandle');
//     menuAtivado.classList.remove('ativo');
//     console.log('oks');
//     domElementoHtml.removeEventListener('click',excluirFinal);
//     menuAtivado.classList.remove('ativo');
//   }
// });
// }

// Get a reference to the <button>
// const btn = document.querySelector('button');

// // Define object with `handleEvent` function
// const myObject = {
//   handleEvent: (event) => {
//     alert(event.type);
//   }
// }

// // Listen for 'click' events on the <button> and handle them with `myObject`... WHAT?!?!

