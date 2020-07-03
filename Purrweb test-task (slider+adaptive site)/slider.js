/* Индекс слайда по умолчанию */
var slideIndex = 0;

/*Маркер, определяющий пройдет нажатие или нет*/
var flag = true;
//Начальное состояние слайдера
setSlide(0);

/* Увеличивает индекс на 1, показывает следующий слайд и передает направление анимации*/
function plusSlide() {
    if (flag) {
        showSlides(slideIndex += 1, 'right');
    }
}

/*Аналогично влево*/
function minusSlide() {
    if (flag) {
        showSlides(slideIndex -= 1, 'left');
    }
}

/* Устанавливает текущий слайд */
function setSlide(index) {
    if (flag = true) {
        flag = false;
        var slides = document.getElementsByClassName("slider__item");
        var paginators = document.getElementsByClassName("circle");

        for (i = 0; i < slides.length; i++) {
            if (i != index) {
                slides[i].style.right = -450 + "px";
                paginators[i].className = "circle";
            }
        }
        slides[index].style.right = 0;

        paginators[index].className += " circle-active";
        slideIndex = index;
    }
    flag = true;
}

/* Основная функция слайдера */
function showSlides(index, direction) {
    var slides = document.getElementsByClassName("slider__item");
    var paginators = document.getElementsByClassName("circle");

    flag = false;
    //Всякие настройки
    var nonePozCoordinate;
    var moveValue;
    var intervalValue;
    var indexOldImg;
    var moveSpeed = 5;

    //Тут закольцовывается
    if (index >= slides.length) {
        indexOldImg = slides.length - 1;
        slideIndex = 0
    }
    if (index == -1) {
        indexOldImg = 0;
        slideIndex = slides.length - 1;
    }

    //Устанавливаем слайды слева или справа в зависимости от направления анимации
    if (direction == 'right') {
        nonePozCoordinate = -400;
        moveValue = 5;
        intervalValue = -50;
        indexOldImg = index - 1;
    } else {
        nonePozCoordinate = 400;
        moveValue = -5;
        intervalValue = 50;
        indexOldImg = index + 1;
    }

    for (i = 0; i < slides.length; i++) {
        if (i != indexOldImg) {
            slides[i].style.right = nonePozCoordinate + intervalValue + "px";
        }
    }

    let newSlidePoz = nonePozCoordinate + intervalValue;
    let oldSlidePoz = 0;

    //Собственно, анимация
    let timer = setInterval(function () {
        if (newSlidePoz == 0) {
            clearInterval(timer);
            flag = true;
            return;
        }

        slides[slideIndex].style.right = newSlidePoz + moveValue + 'px';
        slides[indexOldImg].style.right = oldSlidePoz + moveValue + 'px';

        oldSlidePoz += moveValue;
        newSlidePoz += moveValue;
    }, moveSpeed);

    paginators[slideIndex].className += " circle-active";
    paginators[indexOldImg].className = "circle";
}