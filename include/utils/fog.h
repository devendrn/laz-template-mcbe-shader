#ifndef FOG_UTIL_H
#define FOG_UTIL_H

float calculateFogFade(float relativeDepth, vec4 fogDistCtrl) {
  return clamp((relativeDepth - fogDistCtrl.x)/(fogDistCtrl.y - fogDistCtrl.x), 0.0, 1.0);
}

#endif // FOG_UTIL_H
