var gulp = require('gulp');
var jade = require('gulp-jade');

gulp.task('templates', function () {
    var YOUR_LOCALS = {};

    gulp.src('./src/main/webapp/resources/templates/jade/*.jade')
        .pipe(jade({
            locals: YOUR_LOCALS
        }))
        .pipe(gulp.dest('./src/main/webapp/resources/templates/html'))
});

var watcher = gulp.watch('./src/main/webapp/resources/templates/jade/*.jade', ['templates']);
watcher.on('change', function (event) {
    console.log('File ' + event.path + ' was ' + event.type + ', running tasks...');
});

