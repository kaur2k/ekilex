// GULP TASKS

// define variables
var gulp = require('gulp');
var data = require('gulp-data');
var nunjucksRender = require('gulp-nunjucks-render');
var browserSync = require('browser-sync').create();

//////////////

// run all tasks if files are saved
gulp.task('watch', ['nunjucks', 'browserSync'], function(){
    gulp.watch('app/**/**/*.+(scss|html|js|json|nunjucks)').on('change', browserSync.reload)

	gulp.watch('app/**/**/*.+(scss|html|js|json|nunjucks)', ['nunjucks'])

})


// nunjucks task
gulp.task('nunjucks', function(){
	return gulp.src('app/pages/**/*.+(html|json|nunjucks)')
	.pipe(data(function() {
    	return require('./app/data.json')
    }))
	.pipe(nunjucksRender({
		path: ['app/templates']
	}))
	.pipe(gulp.dest('app'));
});

// browsersync task
gulp.task('browserSync', function() {
	browserSync.init({
		server: {
			baseDir: 'app'
		},
	})
})
