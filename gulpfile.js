const gulp = require('gulp');
const sass = require('gulp-sass');

//compile scss into css
const SRC = "src/main/resources";
const DEST = "src/main/resources/static/css";

function style() {
    return gulp.src(SRC+'/scss/main.scss')
        .pipe(sass({
            outputStyle: 'compressed',
            compass: true,
            bundleExec: true,
            sourcemap: true,
            sourcemapPath: SRC
        }).on('error',sass.logError))
        .pipe(gulp.dest(DEST));
}

function templates(){
    return gulp.src(SRC + "/**/*.*")
        .pipe(gulp.dest('build/resources/main/'));
}

function watch() {
    gulp.watch(SRC+'/**/*.scss', style)
    gulp.watch(SRC+'/**/*.*', templates)

}

exports.style = style;
exports.template = templates;
exports.watch = watch;