# image-blend-examples
Android Jetpack Compose: testing the effects of BlendMode with Image ColorFilter.

    Image(
      painter = painterResource(id = R.drawable.ic_coati),
      colorFilter = CororFilter.tint(blendMode = mode, color = Color.Green),
      )

Resulting display:

<img src="ImageColorFilterTinitBlendMode_part1.png" alt="part1" width="200"/>
<img src="ImageColorFilterTinitBlendMode_part2.png" alt="part2" width="200"/>
