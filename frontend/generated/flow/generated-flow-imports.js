import 'Frontend/generated/jar-resources/flow-component-renderer.js';
import '@vaadin/polymer-legacy-adapter/style-modules.js';
import 'Frontend/generated/jar-resources/vaadin-grid-flow-selection-column.js';
import '@vaadin/text-field/src/vaadin-text-field.js';
import '@vaadin/form-layout/src/vaadin-form-layout.js';
import '@vaadin/dialog/src/vaadin-dialog.js';
import '@vaadin/vertical-layout/src/vaadin-vertical-layout.js';
import '@vaadin/app-layout/src/vaadin-app-layout.js';
import '@vaadin/tooltip/src/vaadin-tooltip.js';
import '@vaadin/app-layout/src/vaadin-drawer-toggle.js';
import '@vaadin/context-menu/src/vaadin-context-menu.js';
import 'Frontend/generated/jar-resources/contextMenuConnector.js';
import 'Frontend/generated/jar-resources/contextMenuTargetConnector.js';
import '@vaadin/form-layout/src/vaadin-form-item.js';
import '@vaadin/horizontal-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/grid/src/vaadin-grid.js';
import '@vaadin/grid/src/vaadin-grid-column.js';
import '@vaadin/grid/src/vaadin-grid-sorter.js';
import '@vaadin/checkbox/src/vaadin-checkbox.js';
import 'Frontend/generated/jar-resources/gridConnector.ts';
import '@vaadin/button/src/vaadin-button.js';
import 'Frontend/generated/jar-resources/buttonFunctions.js';
import '@vaadin/grid/src/vaadin-grid-column-group.js';
import 'Frontend/generated/jar-resources/lit-renderer.ts';
import '@vaadin/notification/src/vaadin-notification.js';
import '@vaadin/common-frontend/ConnectionIndicator.js';
import '@vaadin/vaadin-lumo-styles/color-global.js';
import '@vaadin/vaadin-lumo-styles/typography-global.js';
import '@vaadin/vaadin-lumo-styles/sizing.js';
import '@vaadin/vaadin-lumo-styles/spacing.js';
import '@vaadin/vaadin-lumo-styles/style.js';
import '@vaadin/vaadin-lumo-styles/vaadin-iconset.js';

const loadOnDemand = (key) => {
  const pending = [];
  if (key === '03f4163eae2abee8e143719af8ed4e318bfbe91f4825d6e5c22a568630a53ac0') {
    pending.push(import('./chunks/chunk-8f33b3beade92a8460be428fdb88dc280dad353da2db0dc6d2200c28ba044e9f.js'));
  }
  if (key === '343d1edf425301e24ff342c2f6b905db6d133f9f7fd49ac86ac8e077808af19b') {
    pending.push(import('./chunks/chunk-8f33b3beade92a8460be428fdb88dc280dad353da2db0dc6d2200c28ba044e9f.js'));
  }
  if (key === 'c5b007bd5a0aca3d184fee111d35ee9ace4231a9deabdca94b7da2bf9c593671') {
    pending.push(import('./chunks/chunk-5f1d3a5475e8eb8986c60a4923f7df1656219635d054898590b8938b99012183.js'));
  }
  if (key === 'aa48c45be28a503244cbbaeedf83c70543b6874196373acfd0ea38ba0e98f780') {
    pending.push(import('./chunks/chunk-26275b93afd50764807baca105a24b07df82777c25f3909b3fa711f3bc2890f9.js'));
  }
  if (key === 'afa626c8c5bb539b1ff3e765f1360cb4cb6db4d8ebdebdb9bb88c635ec40012b') {
    pending.push(import('./chunks/chunk-26275b93afd50764807baca105a24b07df82777c25f3909b3fa711f3bc2890f9.js'));
  }
  if (key === '1bb0f28a924a10d57ef26a7a6d4153259f4fb86d9057a058db9f4b24513c686d') {
    pending.push(import('./chunks/chunk-26275b93afd50764807baca105a24b07df82777c25f3909b3fa711f3bc2890f9.js'));
  }
  if (key === '30976f3ec69e423a2c86176d69b38ce0ba87d9e0800a33695b9dbe50af38be55') {
    pending.push(import('./chunks/chunk-26275b93afd50764807baca105a24b07df82777c25f3909b3fa711f3bc2890f9.js'));
  }
  if (key === '868c1287ad14e5360f25a205ae8415fabe4ed68d27d4d2fe43061236c40ff585') {
    pending.push(import('./chunks/chunk-26275b93afd50764807baca105a24b07df82777c25f3909b3fa711f3bc2890f9.js'));
  }
  if (key === '9e5d163688875405922ec2c1ed0042f52323b09e9764738317f1f88ffce3e514') {
    pending.push(import('./chunks/chunk-b9428377dde034d9da3b53b00bef662dd9f037787a5f591463b8a6ecd2449ecb.js'));
  }
  if (key === 'dc54f3f1a25048f4e58b818b2803a93e9be860a6028b1918ba52fa5d3228b2ab') {
    pending.push(import('./chunks/chunk-26275b93afd50764807baca105a24b07df82777c25f3909b3fa711f3bc2890f9.js'));
  }
  return Promise.all(pending);
}

window.Vaadin = window.Vaadin || {};
window.Vaadin.Flow = window.Vaadin.Flow || {};
window.Vaadin.Flow.loadOnDemand = loadOnDemand;
window.Vaadin.Flow.resetFocus = () => {
 let ae=document.activeElement;
 while(ae&&ae.shadowRoot) ae = ae.shadowRoot.activeElement;
 return !ae || ae.blur() || ae.focus() || true;
}