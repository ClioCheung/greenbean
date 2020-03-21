(function () {
    $(function () {
        const ratingStarIntroText = ['', 'Very bad', 'Bad', 'Average', 'Good', 'Very good'];
        const ratingClickStar = $('#ratingClickStar');
        const ratingStarIntro = $('#ratingStarIntro');
        initRating(ratingClickStar, ratingStarIntro);
        ratingClickStar.on('click',function () {
            const inputType = $('#saveOrUpdateUserRatingForm>input[name=type]');
            inputType.val(2);
        });
        
        const dialogRatingClickStar = $('#dialogRatingClickStar');
        const dialogRatingStarIntro = $('#dialogRatingStarIntro');
        initRating(dialogRatingClickStar, dialogRatingStarIntro);
        
        const userRatingClickStar = $('#userRatingClickStar');
        const userRatingStarIntro = $('#userRatingStarIntro');
        initRating(userRatingClickStar, userRatingStarIntro);
        userRatingClickStar.on('click', function () {
            $('#saveOrUpdateUserRatingForm').trigger('submit');
        });
        
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
                
                const score = imgIndex * 2;
                $('#saveOrUpdateUserRatingForm>input[name=score]').val(score);
            });
        }
    
        function makeStarSolid(ratingClickStar, ratingStarIntro, targetIndex){
            ratingClickStar.children().each(function (index, element) {
                const img = $(element.firstElementChild);
                if (index < targetIndex) {
                    img.attr('src', ratingClickStar.attr('data-solid'));
                } else {
                    img.attr('src', ratingClickStar.attr('data-hollow'));
                }
            });
            // targetIndex必须为数字，不能为空串''。
            ratingStarIntro.text(ratingStarIntroText[targetIndex]);
        }
        
        $('.ratingSignRow>button').on('click', function () {
            const buttonId = $(this).attr('id');
            const inputType = $('#saveOrUpdateUserRatingForm>input[name=type]');
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
            // TODO 查清楚这的0与''的区别
            let starCount = 0;
            let score = '';
            if(originalRating !== undefined){
                starCount = originalRating;
                score = originalRating * 2;
            }
            if(originalType !== undefined){
                $('#saveOrUpdateUserRatingForm input[name=type][value='+ originalType +']').prop('checked',true);
            } else {
                $('#saveOrUpdateUserRatingForm>input[name=type][type=hidden]').val('');
            }
            makeStarSolid(ratingClickStar, ratingStarIntro, starCount);
            dialogRatingClickStar.attr('data-rating',starCount);
            dialogRatingClickStar.triggerHandler('mouseleave');
            $('#saveOrUpdateUserRatingForm input[name=score]').val(score);
        });
        
        $('#saveButton').on('click', function () {
            $('#saveOrUpdateUserRatingForm').trigger('submit');
        });
        
        $('#removeButton').on('click', function () {
            $('#removeUserRatingForm').trigger('submit');
        });
    });
})();
