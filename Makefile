build-all: build-html build-pdf build-pptx create-index

build-html:
	marp -I . && cp -r images dist/ 

build-pdf:
	marp --pdf -I .

build-pptx:
	marp --pptx -I .

create-index: 
	cd dist && sh -c 'tree \
    -H "." \
    -L 1 \
    --noreport \
    --houtro ""\
    -I "index.html" \
    -T "EDDYA" \
    --ignore-case \
    --timefmt "%d-%b-%Y %H:%M" \
    -s \
    -D \
		-I "images" \
    -o "./index.html"' {} \;
