---
layout: post
title: "Markdown &amp; HTML Pages"
description: "Examples of trying to format HTML pages in GitHub."
category: articles
tags: [markdown, github]
---

#### All I am trying to do is format the words on the page of the blog. Should be easy right? WRONG!

#### Now I have this whole other language to learn ... it's called Markdown and it is what GitHub uses to render the layout of the page ...SMH!

#### You know I am spending all this time configuring a blog and not enough time building the App which is my goal in the first place, but this as well is another one of my learning opportunities so I will stop griping about it.

#### My problem came about because I was trying to put a fairly short note on my home page without creating a separate page and then working it into the home page by writing code. Well I should have opted to write the code, cause it took me a very long time to make it look readable.

#### HTML & Markdown together on one page does not play nice. Since the page in question was a HTML page, I assumed all HTML tags would work. They don't. Markdown completely ignores paragraph tags by giving me line breaks. Example below:

<figure>
	<img src="/images/image-filename-1.jpg">
	<figcaption>Image of example of line breaks instead of paragraphs</figcaption>
</figure>

#### Now before the Techies start saying ...well you should just leave a blank line between your paragraphs, well what I got from that was jumbling all the text together. That looked like this:

<figure>
	<a href="http://chintani.github.io/Learn-To-Build-Andriod-Apps/images/2013-09-27_2114.png"><img src="http://chintani.github.io/Learn-To-Build-Andriod-Apps/images/2013-09-27_2114.png"></a>
	<figcaption><a href="http://chintani.github.io/Learn-To-Build-Andriod-Apps/images/2013-09-27_2114.png" title="Image of example of paragraphs all in one"></a>.</figcaption>
</figure>
		

#### Next I tried using Markdown on the page because everything else was not working ... I was sure I got it this time. Well see the example for yourself.

<figure>
	<a href="http://chintani.github.io/Learn-To-Build-Andriod-Apps/images/2013-09-28_0135.png"><img src="http://chintani.github.io/Learn-To-Build-Andriod-Apps/images/2013-09-28_0135.png"></a>
	<figcaption><a href="http://chintani.github.io/Learn-To-Build-Andriod-Apps/images/2013-09-28_0135.png" title="Image of example with the # sign clearly visible to viewers of the blog"></a>.</figcaption>
</figure>
	

#### I know that I am doing something wrong but until I find out, that's my story and I am sticking to it! In the end I decided to use "H" tags to make my paragraphs look like paragraphs. Not ideal but works for now until I figure out where I went wrong. The words on my blog now looks like this:

<figure>
	<a href="http://chintani.github.io/Learn-To-Build-Andriod-Apps/images/2013-09-28_0211.png"><img src="http://chintani.github.io/Learn-To-Build-Andriod-Apps/images/2013-09-28_0211.png"></a>
	<figcaption><a href="http://chintani.github.io/Learn-To-Build-Andriod-Apps/images/2013-09-28_0211.png" title="Image of example using HTML H tags"></a>.</figcaption>
</figure>
		

#### Since I had so much trouble with Markdown and my HTML page I went ahead and downloaded a "Markdown" text editor called <a markdown="0" href="http://markdownpad.com/">Markdown Pad</a>. Hope it makes writing in markdown a bit easier.




   








