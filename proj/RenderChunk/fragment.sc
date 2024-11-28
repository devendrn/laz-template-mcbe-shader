$input v_texcoord0, v_color0, v_fog, v_lightmapUV

#include <bgfx_shader.sh>

#ifndef DEPTH_ONLY_OPAQUE
  SAMPLER2D_AUTOREG(s_LightMapTexture);
  SAMPLER2D_AUTOREG(s_MatTexture);

  #if defined(SEASONS) && (defined(ALPHA_TEST) || defined(OPAQUE))
    SAMPLER2D_AUTOREG(s_SeasonsTexture);
  #endif
#endif

void main() {
  #ifndef DEPTH_ONLY_OPAQUE
    vec4 diffuse = texture(s_MatTexture, v_texcoord0);

    #ifdef ALPHA_TEST
      if (diffuse.a < 0.5) {
        discard;
      }
    #endif

    #if defined(SEASONS) && (defined(ALPHA_TEST) || defined(OPAQUE))
      diffuse.rgb *= mix(vec3_splat(1.0), 2.0 * texture2D(s_SeasonsTexture, v_color0.xy).rgb, v_color0.y);
      diffuse.rgb *= v_color0.aaa;
    #else
      diffuse *= v_color0;
    #endif

    diffuse.rgb *= texture(s_LightMapTexture, v_lightmapUV).xyz;
    diffuse.rgb = mix(diffuse.rgb, v_fog.rgb, v_fog.a);

    gl_FragColor = diffuse;
  #else
    gl_FragColor = vec4_splat(0.0);
  #endif
}

