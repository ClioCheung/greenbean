(function () {
    $(function () {
        const ratingClickStar = $('#ratingClickStar');
        const ratingStarIntro = $('#ratingStarIntro');
        initRating(ratingClickStar, ratingStarIntro);
        const dialogRatingClickStar = $('#dialogRatingClickStar');
        const dialogRatingStarIntro = $('#dialogRatingStarIntro');
        initRating(dialogRatingClickStar, dialogRatingStarIntro);
        
        function initRating(ratingClickStar, ratingStarIntro){
            const ratingStarIntroText = ['', 'Very bad', 'Bad', 'Average', 'Good', 'Very good'];
            ratingClickStar.on('mouseover',function (event) {
                const imgIndex = $(event.target).data('index');
                makeStarSolid(ratingClickStar, ratingStarIntro, imgIndex);
            });
            ratingClickStar.on('mouseleave', function () {
                const imgIndex = ratingClickStar.data('rating');
                makeStarSolid(ratingClickStar, ratingStarIntro, imgIndex);
            });
            ratingClickStar.triggerHandler('mouseleave');
            
            function makeStarSolid(ratingClickStar, ratingStarIntro, targetIndex){
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
        }
        
        $('#ratingDialog').on('show.bs.modal', function (event) {
            const button = $(event.relatedTarget);
            const recipient = button.data('status');
            const modal = $(this);
            modal.find('.modal-title>span').text(recipient);
        });
    });
})();
