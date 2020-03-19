(function () {
    $(function () {
        const ratingClickStar = $('#ratingClickStar');
        const ratingStarIntro = $('#ratingStarIntro');
        initRating(ratingClickStar, ratingStarIntro);
        const dialogRatingClickStar = $('#dialogRatingClickStar');
        const dialogRatingStarIntro = $('#dialogRatingStarIntro');
        initRating(dialogRatingClickStar, dialogRatingStarIntro);
        const userRatingClickStar = $('#userRatingClickStar');
        const userRatingStarIntro = $('#userRatingStarIntro');
        initRating(userRatingClickStar, userRatingStarIntro);
        
        function initRating(ratingClickStar, ratingStarIntro){
            ratingClickStar.on('mouseover',function (event) {
                const imgIndex = $(event.target).attr('data-index');
                makeStarSolid(ratingClickStar, ratingStarIntro, imgIndex);
            });
            ratingClickStar.on('mouseleave', function () {
                const imgIndex = ratingClickStar.attr('data-rating');
                makeStarSolid(ratingClickStar, ratingStarIntro, imgIndex);
            });
            ratingClickStar.triggerHandler('mouseleave');
            ratingClickStar.on('click', function (event) {
                const imgIndex = $(event.target).attr('data-index');
                const dialogRatingClickStar = $('#dialogRatingClickStar');
                dialogRatingClickStar.attr('data-rating',imgIndex);
                dialogRatingClickStar.triggerHandler('mouseleave');
                const ratingStar = ratingClickStar.attr('id');
                if(ratingStar == 'ratingClickStar'){
                    const inputType = $('form>input[name=type]');
                    inputType.val(2);
                }
                const score = imgIndex*2;
                $('form>input[name=score]').val(score);
            });
        }
    
        function makeStarSolid(ratingClickStar, ratingStarIntro, targetIndex){
            const ratingStarIntroText = ['', 'Very bad', 'Bad', 'Average', 'Good', 'Very good'];
            ratingClickStar.children().each(function (index, element) {
                const img = $(element.firstElementChild);
                if (index < targetIndex) {
                    img.attr('src', ratingClickStar.attr('data-solid'));
                } else {
                    img.attr('src', ratingClickStar.attr('data-hollow'));
                }
            });
            ratingStarIntro.text(ratingStarIntroText[targetIndex]);
        }
        
        $('.ratingSignRow>button').on('click', function () {
            const buttonId = $(this).attr('id');
            const inputType = $('form>input[name=type]');
            // XXX 硬编码
            if(buttonId == 'readingButton'){
                inputType.val(1);
            }else if(buttonId == 'readButton'){
                inputType.val(2);
            }
        });
        
        const ratingDialog = $('#ratingDialog');
        ratingDialog.on('show.bs.modal', function (event) {
            const button = $(event.relatedTarget);
            const recipient = button.data('status');
            const modal = $(this);
            modal.find('.modal-title>span').text(recipient);
        });
        ratingDialog.on('hide.bs.modal', function () {
            const ratingSign = $('#ratingSignDiv');
            const originalRating =  ratingSign.attr('data-rating');
            const originalType =  ratingSign.attr('data-type');
            let starCount = '';
            let score = '';
            if(originalRating !== undefined){
                starCount = originalRating;
                score = originalRating * 2;
            }
            if(originalType !== undefined){
                $('#userRatingForm input[name=type][value='+ originalType +']').prop('checked',true);
            } else {
                $('#userRatingForm>input[name=type][type=hidden]').val('');
            }
            makeStarSolid(ratingClickStar, ratingStarIntro, starCount);
            dialogRatingClickStar.attr('data-rating',starCount);
            dialogRatingClickStar.triggerHandler('mouseleave');
            $('#userRatingForm input[name=score]').val(score);
        });
        
        $('#saveButton').on('click', function () {
            $('form').trigger('submit');
        });
    });
})();
